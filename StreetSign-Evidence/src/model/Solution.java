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

	public Solution(int dim, String[] set1, String[] set2, double[] probs1,
			double[] probs2) {
		table = new Cell[dim];
		this.set1 = set1;
		this.set2 = set2;
		this.probs1 = probs1;
		this.probs2 = probs2;
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
		// TODO Tabelle füllen und Wahrscheinlichkeiten berechnen (mit
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

				table[dim].setProbability(probs1[i] * probs2[j]);
				dim++;
			}
		}

		determineK();
		calcNewProbs();

	}
	
	private void calcNewProbs()
	{
		for(Cell cell : table)
			if(cell.getIntersectionAsString().equalsIgnoreCase(" "))
				cell.setProbability(0.0);
			else
				cell.setProbability(cell.getProbability()*k);
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

	// public String toString() {
	// StringBuilder sb = new StringBuilder();
	// sb.append("Table: (correction factor: " + k + ")\n");
	// sb.append("Left Top: {" + table[0].getIntersectionAsString() + "} / "
	// + table[0].getProbability() + "\n");
	// sb.append("Right Top: {" + table[1].getIntersectionAsString() + "} / "
	// + table[1].getProbability() + "\n");
	// sb.append("Left Bottom: {" + table[2].getIntersectionAsString()
	// + "} / " + table[2].getProbability() + "\n");
	// sb.append("Right Bottom: {" + table[3].getIntersectionAsString()
	// + "} / " + table[3].getProbability() + "\n");
	// return sb.toString();
	// }

}
