package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Primitive {

	private int id;
	// String: Type
	// Double: Reliability
	private HashMap<String, Double> map;

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
