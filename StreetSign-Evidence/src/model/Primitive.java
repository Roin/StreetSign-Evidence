package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Primitive {

	private int id;
	// String: ElementenMenge
	// Double: Reliability
	private HashMap<String, Double> map;

	private Cell[] evTable;

	public void calcEvidence() {

		evTable = new Cell[2];
		Iterator<Entry<String, Double>> it = getIterator();
		
		if(it.hasNext()){
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
		}
		else
			System.err.println("No Element in the Hashmap!");
		
		System.out.println(evTable);
		for(Cell cell: evTable)
			System.out.println("	" +cell.getProbability() + " " + cell.getIntersectionAsString());

	}

	public Primitive() {
		map = new HashMap<String, Double>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Double> getMap() {
		return map;
	}

	public void addToMap(String type, Double reliability) {
		map.put(type, reliability);
	}

	public Iterator<Entry<String, Double>> getIterator() {
		return map.entrySet().iterator();
	}

	public String toString() {
		return "{Primitive " + id + ": " + map + "}";
	}

}
