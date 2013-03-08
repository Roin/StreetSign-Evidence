package main;

import java.util.ArrayList;

import model.Relation;
import model.Sign;
import util.CSVParser;

public class Anwendung {
	
	static private ArrayList<Sign> signs = new ArrayList<Sign>();
	
	public static void main(String[] args) {
		System.out.println("Start ...");
		CSVParser parser = new CSVParser("../testdata2.csv");
		parser.parse();

		for (Relation rel : parser.getRelations()) {
			rel.calculateEvidence();
			
			if(rel.generateSign() != null)
//				signs.add(rel.generateSign());
			System.out.println(rel.generateSign());
			


		}

		System.out.println("Ending ...");

	}
}