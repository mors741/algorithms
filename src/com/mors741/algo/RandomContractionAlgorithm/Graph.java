package com.mors741.algo.RandomContractionAlgorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Graph {

	private int curAlias = 0;
	private ArrayList<Edge> edges;
	private Map<Integer, ArrayList<Integer>> adjacencyList;
	private Map<Integer, ArrayList<Integer>> aliases;

	public Graph(String filePath) {
		edges = new ArrayList<Edge>(198);
		adjacencyList = new HashMap<Integer, ArrayList<Integer>>(200);
		aliases = new HashMap<Integer, ArrayList<Integer>>(200);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				ArrayList<Integer> tempAr = new ArrayList<>(50);
				String[] tokens = line.split("	");
				for (int i = 1; i < tokens.length; i++) {
					tempAr.add(Integer.parseInt(tokens[i]));
					edges.add(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i])));
				}
				adjacencyList.put(Integer.parseInt(tokens[0]), tempAr);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void reset() {
		aliases.clear();
		edges.clear();
		curAlias = 0;
		for (Integer vertice : adjacencyList.keySet()) {
			for (Integer neighbor : adjacencyList.get(vertice)) {
				edges.add(new Edge(vertice, neighbor));
			}
		}
	}

	public int countMinCut() {
		int bestCutRes = Integer.MAX_VALUE;
		ArrayList<Integer> bestCut = null;
		for (int i = 0; i < adjacencyList.size(); i++){
			Random rand = new Random();
			while (curAlias > 2 - adjacencyList.size()) {
				Edge e = edges.get(rand.nextInt(edges.size()));
				contract(e.vert1, e.vert2);
			}
			int res = countEdges();
			if (res < bestCutRes){
				bestCutRes = res;
				bestCut = aliases.get(curAlias + 1);
			}
			reset();
			
		}
		
		System.out.println();
		System.out.print("Best: ");
		for (Integer i : bestCut) {
			System.out.print(i + " ");
		}
		System.out.println("  ->  " + bestCutRes);
		
		return bestCutRes;

	}

	public void contract(int vert1, int vert2) {
		// manageAliases
		ArrayList<Integer> tempAr = new ArrayList<Integer>();
		if (vert1 > 0) {
			tempAr.add(vert1);
		} else {
			tempAr.addAll(aliases.get(vert1));
		}
		if (vert2 > 0) {
			tempAr.add(vert2);
		} else {
			tempAr.addAll(aliases.get(vert2));
		}
		aliases.put(curAlias, tempAr);

		int i = 0;
		while (i < edges.size()) {
			Edge e = edges.get(i);
			if (e.vert1 == vert1 || e.vert1 == vert2) {
				e.vert1 = curAlias;
			}
			if (e.vert2 == vert1 || e.vert2 == vert2) {
				e.vert2 = curAlias;
			}
			if (e.vert1 == curAlias && e.vert2 == curAlias) {
				edges.remove(i--);
			}
			i++;
		}

		--curAlias;
	}

	public int countEdges() {
		int count = 0;
		ArrayList<Integer> lastAlias = aliases.get(curAlias + 1);
		for (Integer vertex : adjacencyList.keySet()) {
			if (!lastAlias.contains(vertex)) {
				for (Integer neighbor : adjacencyList.get(vertex)) {
					if (lastAlias.contains(neighbor)) {
						count++;
					}
				}
			}
		}

//		for (Integer i : lastAlias) {
//			System.out.print(i + " ");
//		}
//		System.out.println("  ->   " + count);

		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(10000);

		for (Map.Entry<Integer, ArrayList<Integer>> entry : adjacencyList.entrySet()) {
			sb.append(entry.getKey() + ": ");
			for (Integer vertice : entry.getValue()) {
				sb.append(vertice + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}
