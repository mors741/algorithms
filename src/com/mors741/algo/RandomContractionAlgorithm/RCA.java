package com.mors741.algo.RandomContractionAlgorithm;

public class RCA {
	
	public static void contract() {
		
	}

	public static void main(String[] args) {
		Graph graph =new Graph("resources/kargerMinCut.txt");
//		System.out.println(graph.toString());
//		graph.contract(1, 4);
//		graph.contract(3, 6);
//		graph.contract(-2, 5);
//		graph.contract(-1, 2);
		System.out.println(graph.countMinCut());
	}

}
