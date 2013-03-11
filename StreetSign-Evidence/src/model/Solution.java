package model;

import java.util.Map;

public class Solution {

	private String[] set1;
	private String[] set2;
	private double[] probs1;
	private double[] probs2;
	// Korrekturfaktor
	private double k;

	private Cell[] table;

	public Solution(int dim) {
		table = new Cell[dim];
	}

	public Solution(Cell[] t1, Cell[] t2) {

		table = new Cell[t1.length * t2.length];

		set1 = new String[t1.length];
		set2 = new String[t2.length];
		probs1 = new double[t1.length];
		probs2 = new double[t2.length];

		for (int i = 0; i < t1.length; i++) {
			set1[i] = t1[i].getIntersectionAsString();
			probs1[i] = t1[i].getProbability();
		}

		for (int i = 0; i < t2.length; i++) {
			set2[i] = t2[i].getIntersectionAsString();
			probs2[i] = t2[i].getProbability();
		}

		calculateTable();
	}

	public Solution(Cell[] oldTable, Map.Entry<String, Double> pair) {
		table = new Cell[oldTable.length * 2];
		set1 = new String[oldTable.length];
		set2 = new String[2];
		probs1 = new double[oldTable.length];
		probs2 = new double[2];

		set2[0] = pair.getKey();
		set2[1] = "omega";

		probs2[0] = pair.getValue();
		probs2[1] = 1 - pair.getValue();

		for (int i = 0; i < oldTable.length; i++) {
			set1[i] = oldTable[i].getIntersectionAsString();
			probs1[i] = oldTable[i].getProbability();
		}

		calculateTable();
	}

	public void calculateTable() {
		// TODO Tabelle fuellen und Wahrscheinlichkeiten berechnen (mit
		// Korrekturfaktor!)

		// Location in Solution table
		int dim = 0;

		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				table[dim] = new Cell();
				if (set1[i].equalsIgnoreCase(set2[j]))
					table[dim].addIntersection(set1[i]);
				else if (set1[i].equalsIgnoreCase("omega"))
					table[dim].addIntersection(set2[j]);
				else if (set2[j].equalsIgnoreCase("omega"))
					table[dim].addIntersection(set1[i]);
				else
					table[dim].addIntersection(" ");

				table[dim].setProbability(probs1[i] * probs2[j]);
				dim++;
			}
		}

		determineK();
		calcNewProbs();

	}

	private void calcNewProbs() {
		for (Cell cell : table)
			if (cell.getIntersectionAsString().equalsIgnoreCase(" "))
				cell.setProbability(0.0);
			else
				cell.setProbability(cell.getProbability() * k);
	}

	private double determineK() {
		double conflict = 0.0;

		for (Cell cell : table)
			if (cell.getIntersectionAsString().equalsIgnoreCase(" "))
				conflict += cell.getProbability();

		k = 1 / (1 - conflict);

		return k;
	}

	public double getK() {
		return k;
	}

	public Cell[] getSolution() {
		return table;
	}

	public double getPlausibility(String type) {
		double pl = 0.0;

		for (Cell cell : table) {
			if (cell.getIntersectionAsString().equalsIgnoreCase(type)
					|| cell.getIntersectionAsString().equalsIgnoreCase("omega"))
				pl += cell.getProbability();
		}

		return pl * 0.75;
	}

	public double getBelief(String type) {
		double belief = 0.0;

		for (Cell cell : table) {
			if (cell.getIntersectionAsString().equalsIgnoreCase(type))
				belief += cell.getProbability();
		}

		return belief * 0.75;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Table: \n");
		for (Cell cell : table)
			sb.append(cell.toString() + "\n");

		return sb.toString();
	}

}
