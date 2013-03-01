package model;

public class Solution {

	private String type1;
	private String type2;
	// Korrekturfaktor
	private double k;

	private Cell[][] table;

	public Solution() {
		table = new Cell[2][2];
	}

	private void calculateTable() {
		// TODO Tabelle füllen und Wahrscheinlichkeiten berechnen (mit
		// Korrekturfaktor!)
	}

	private double determineK() {
		if (type1.equalsIgnoreCase(type2))
			k = 1;
		else {
			// k = 1 / (1 - (p1*p2) );
		}
		return 0.0;
	}

}
