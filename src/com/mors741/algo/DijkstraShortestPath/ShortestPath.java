package com.mors741.algo.DijkstraShortestPath;

public class ShortestPath {

	public static void main(String[] args) {
		Graph graph = new Graph("resources/dijkstraData.txt");
		graph.compute();
		System.out.println(graph.toString());
		System.out.println(graph.result());
		// graph.contract(1, 4);
		// graph.contract(3, 6);
		// graph.contract(-2, 5);
		// graph.contract(-1, 2);
		// System.out.println(graph.countMinCut());

	}

}
