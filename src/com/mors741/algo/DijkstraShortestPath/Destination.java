package com.mors741.algo.DijkstraShortestPath;

public class Destination {
	private int vertex;
	private int cost;

	public Destination(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
