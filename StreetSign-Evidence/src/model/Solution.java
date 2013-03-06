package model;

public class Solution {

	private String type1;
	private String type2;
	private double prob1;
	private double prob2;
	// Korrekturfaktor
	private double k;

	private Cell[] table;

	public Solution(int dim) {
		table = new Cell[dim];
	}

	public Solution(int dim, String type1, String type2, double prob1, double prob2) {
		table = new Cell[dim];
		this.type1 = type1;
		this.type2 = type2;
		this.prob1 = prob1;
		this.prob2 = prob2;
		calculateTable();
	}

	public void calculateTable() {
		// TODO Tabelle füllen und Wahrscheinlichkeiten berechnen (mit
		// Korrekturfaktor!)

		determineK();

		// IS type 1 and type 2 --> top left
		table[0] = new Cell();
		if (type1.equalsIgnoreCase(type2)) {
			table[0].addIntersection(type1);
			table[0].setProbability(prob1 * prob2 * k);
		} else {

			table[0].setProbability(0);
		}

		// IS type 1 and Omega2 --> top right
		table[1] = new Cell();
		table[1].addIntersection(type1);
		table[1].setProbability(prob1 * (1 - prob2) * k);

		// IS Omega1 and type 2 --> bottom left
		table[2] = new Cell();
		table[2].addIntersection(type2);
		table[2].setProbability((1 - prob1) * prob2 * k);

		// IS Omega1 and Omega2 --> bottom right
		table[3] = new Cell();
		table[3].addIntersection("omega");
		table[3].setProbability((1 - prob1) * (1 - prob2) * k);

	}

	private double determineK() {
		if (type1.equalsIgnoreCase(type2))
			k = 1;
		else
			k = 1 / (1 - (prob1 * prob2));

		return k;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Table: (correction factor: " + k + ")\n");
		sb.append("Left Top: {" + table[0].getIntersectionAsString() + "} / "
				+ table[0].getProbability() + "\n");
		sb.append("Right Top: {" + table[1].getIntersectionAsString() + "} / "
				+ table[1].getProbability() + "\n");
		sb.append("Left Bottom: {" + table[2].getIntersectionAsString()
				+ "} / " + table[2].getProbability() + "\n");
		sb.append("Right Bottom: {" + table[3].getIntersectionAsString()
				+ "} / " + table[3].getProbability() + "\n");
		return sb.toString();
	}

}
