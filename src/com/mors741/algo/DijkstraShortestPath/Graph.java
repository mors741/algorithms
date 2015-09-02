package com.mors741.algo.DijkstraShortestPath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Graph {

	private static final int SIZE = 200;

	private Destination[][] adjacencyList;
	private int[] vertices;
	private Set<Integer> X = new HashSet<Integer>();

	public Graph(String filePath) {
		adjacencyList = new Destination[SIZE][50];
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			int vertexNumber = 0;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("	");
				for (int i = 1; i < tokens.length; i++) {
					String[] dests = tokens[i].split(",");
					adjacencyList[vertexNumber][i - 1] = new Destination(Integer.parseInt(dests[0]) - 1,
							Integer.parseInt(dests[1]));
				}
				vertexNumber++;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vertices = new int[SIZE];
		vertices[0] = 0;
		for (int i = 1; i < SIZE; i++) {
			vertices[i] = Integer.MAX_VALUE;
		}
		X.add(0);
	}

	public void compute() {
		while (X.size() < SIZE) {
			int dist;
			int minEst = Integer.MAX_VALUE;
			int minEstVert = -1;
			for (Integer vert : X) {
				dist = 0;
				while (adjacencyList[vert][dist] != null) {
					if (vertices[vert] + adjacencyList[vert][dist].getCost() < minEst
							&& !X.contains(adjacencyList[vert][dist].getVertex())) {
						minEst = vertices[vert] + adjacencyList[vert][dist].getCost();
						minEstVert = adjacencyList[vert][dist].getVertex();
					}
					dist++;
				}
			}
			X.add(minEstVert);
			vertices[minEstVert] = minEst;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(10000);
		int dist;
		for (int vert = 0; vert < SIZE; vert++) {
			dist = 0;
			sb.append((vert + 1) + " <" + vertices[vert] + "> : ");
			while (adjacencyList[vert][dist] != null) {
				sb.append(adjacencyList[vert][dist].getVertex() + " [" + adjacencyList[vert][dist].getCost() + "], ");
				dist++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public String result() {
		return vertices[6] + "," + vertices[36] + "," + vertices[58] + "," + vertices[81] + "," + vertices[98] + ","
				+ vertices[114] + "," + vertices[132] + "," + vertices[164] + "," + vertices[187] + "," + vertices[196];
	}

}
