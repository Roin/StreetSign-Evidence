package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>Description of the Primitive class</b> <br>
 * Contains the data about a given Primitive. Contains an evidence table to this
 * Primitive.
 * 
 * @author Watnuss
 * 
 */
public class Primitive {

	private int id;
	// String: ElementenMenge
	// Double: Reliability
	private HashMap<String, Double> map;

	private Cell[] evTable;

	/**
	 * <b>Description of calcEvidence()</b><br>
	 * 
	 * Generates an evidence table for each primitive the classifier recognized
	 * for this object.
	 * 
	 */
	public void calcEvidence() {

		evTable = new Cell[2];
		Iterator<Entry<String, Double>> it = getIterator();

		if (it.hasNext()) {
			Map.Entry<String, Double> pair = it.next();

			evTable[0] = new Cell();
			evTable[0].addIntersection(pair.getKey());
			evTable[0].setProbability(pair.getValue());

			evTable[1] = new Cell();
			evTable[1].addIntersection("omega");
			evTable[1].setProbability(1 - pair.getValue());

			while (it.hasNext()) {
				pair = it.next();
				evTable = new Solution(evTable, pair).getSolution();
			}
		} else
			System.err.println("No Element in the Hashmap!\n");
	}

	/**
	 * <b>Descriptoin of Primitive()</b><br>
	 * Constructor of the Primitive class.
	 */
	public Primitive() {
		map = new HashMap<String, Double>();
	}

	/**
	 * <b>Description of getId()</b><br>
	 * Gets the id of this Primitive.
	 * 
	 * @return The id
	 */
	public int getId() {
		return id;
	}

	/**
	 * <b>Description of setID(int id)</b><br>
	 * Sets the id of this Primitive.
	 * 
	 * @param id
	 *            The id of this Primitive
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * <b>Description of getMap()</b><br>
	 * Gets the Map of primitives of this object and their corresponding
	 * reliabilities.
	 * 
	 * @return
	 */
	public HashMap<String, Double> getMap() {
		return map;
	}

	/**
	 * <b>Description of addToMap(String type, Double reliability)</b><br>
	 * Adds a pair of primitive type and its corresponding reliability to the
	 * Map.
	 * 
	 * @param type
	 *            Type of primitive
	 * @param reliability
	 *            Reliability of related primitive
	 */
	public void addToMap(String type, Double reliability) {
		map.put(type, reliability);
	}

	/**
	 * <b>Description of getIterator()</b><br>
	 * Gets an Iterator of the Map.
	 * 
	 * @return Iterator of the HashMap
	 */
	public Iterator<Entry<String, Double>> getIterator() {
		return map.entrySet().iterator();
	}

	/**
	 * <b>Description of getEvTable()</b><br>
	 * Gets the evidence table of this Primitive.
	 * 
	 * @return Evidence Table of this Primitive
	 */
	public Cell[] getEvTable() {
		return evTable;
	}

	public String toString() {
		return "{Primitive " + id + ": " + map + "}";
	}

}
