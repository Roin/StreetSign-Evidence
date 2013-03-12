package main;

import java.util.ArrayList;

import model.Relation;
import model.Sign;
import util.CSVParser;

/**
 * <b>Description of Anwendung</b> <br>
 * Main class of the StreetSign Evidence application
 * 
 * @author Watnuss
 * 
 */
public class Anwendung {

	// Contains recognized signs
	static private ArrayList<Sign> signs = new ArrayList<Sign>();
	static private ArrayList<Relation> relations = new ArrayList<Relation>();

	/**
	 * <b>Description of the main function</b> <br>
	 * 
	 * @param args
	 *            Path to the file which contains the input data
	 */
	public static void main(String[] args) {
		System.out.println("Start ...");
		CSVParser parser;
		
		if (args.length == 0)
			parser = new CSVParser("testdata2.csv");
		else
			parser = new CSVParser(args[0].toString());

		parser.parse();

		Sign tmpSign;
		for (Relation rel : parser.getRelations()) {
			rel.calculateEvidence();
			relations.add(rel);

			if ((tmpSign = rel.generateSign()) != null)
				signs.add(tmpSign);
		}

		for (Sign sign : signs) {
			sign.generateRelation(relations, signs);
		}

		for (Sign sign : signs)
			System.out.println(sign);

		System.out.println("Ending ...");

	}
}