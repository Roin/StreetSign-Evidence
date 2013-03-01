package model;

import java.util.HashMap;

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

	public void setMap(HashMap<String, Double> map) {
		this.map = map;
	}



}
