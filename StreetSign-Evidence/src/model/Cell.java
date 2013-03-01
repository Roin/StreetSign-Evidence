package model;

import java.util.ArrayList;

public class Cell {
	
	private double probability;
	private ArrayList<String> intersection;
	
	public Cell()
	{
		intersection = new ArrayList<String>();
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public ArrayList<String> getIntersection() {
		return intersection;
	}

	public void addIntersection(String element) {
		intersection.add(element);
	}
	
	

}
