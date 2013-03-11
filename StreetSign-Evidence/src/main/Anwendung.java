package main;

import java.util.ArrayList;

import model.Relation;
import model.Sign;
import util.CSVParser;

public class Anwendung {

	// Contains recognized signs
	static private ArrayList<Sign> signs = new ArrayList<Sign>();
	static private ArrayList<Relation> relations = new ArrayList<Relation>();

	public static void main(String[] args) {
		System.out.println("Start ...");
		CSVParser parser;
		System.out.println("args length:" + args.length);
		if (args.length == 0)
			parser = new CSVParser("../testdata2.csv");
		else
			parser = new CSVParser(args[1].toString());

		parser.parse();

		for (Relation rel : parser.getRelations()) {
			rel.calculateEvidence();
			relations.add(rel);

			if (rel.generateSign() != null)
				signs.add(rel.generateSign());
		}

		for (Sign sign : signs) {
			sign.generateRelation(relations, signs);
		}

		for (Sign sign : signs)
			System.out.println(sign);

		System.out.println("Ending ...");

	}
}