package model;

import java.util.ArrayList;

public class Cell {

	private double probability;
	private ArrayList<String> intersection;

	public Cell() {
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

	public String getIntersectionAsString() {
		if (intersection.isEmpty())
			return " ";
		else
			// temporarily, as there is always just one element
			return intersection.get(0);
	}

	public void addIntersection(String element) {
		intersection.add(element);
	}

	public String toString() {
		return (intersection.isEmpty()) ? "{ }" : "{ " + intersection.get(0)
				+ " } / " + probability;
	}

}
