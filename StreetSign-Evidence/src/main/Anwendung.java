package main;

import model.Relation;
import model.Solution;
import util.CSVParser;

public class Anwendung {
	public static void main(String[] args) {
		System.out.println("Start ...");
		CSVParser parser = new CSVParser("../testdata2.csv");
		parser.parse();

		for (Relation rel : parser.getRelations()) {
			rel.calculateEvidence();
			
			for(Solution s : rel.getSolutions())
				System.out.println(s);

		}

		System.out.println("Ending ...");

	}
}