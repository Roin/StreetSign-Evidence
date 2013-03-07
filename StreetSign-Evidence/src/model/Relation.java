package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Relation {
	private String type;
	private Primitive prim1;
	private Primitive prim2;

	private ArrayList<Solution> solutions;

	public Relation() {
		solutions = new ArrayList<Solution>();
	}

	public void calculateEvidence() {
		
		prim1.calcEvidence();
		prim2.calcEvidence();
		
		System.out.println(prim1);
		System.out.println(prim2);
		
		
		
//		Iterator<Entry<String, Double>> it1 = prim1.getIterator();
//		Iterator<Entry<String, Double>> it2 = prim2.getIterator();
//
//		Map.Entry<String, Double> pair1;
//		Map.Entry<String, Double> pair2;
//		while (it1.hasNext()) {
//			pair1 = (Map.Entry<String, Double>) it1.next();
//
//			while (it2.hasNext()) {
//				pair2 = (Map.Entry<String, Double>) it2.next();
//				solutions.add(new Solution(4, pair1.getKey(), pair2.getKey(),
//						pair1.getValue(), pair2.getValue()));
//
//			}
//
//			// "Reset" the inner iterator it2
//			it2 = prim2.getIterator();
//		}
	}

	public ArrayList<Solution> getSolutions() {
		return solutions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Primitive getPrim1() {
		return prim1;
	}

	public void setPrim1(Primitive prim1) {
		this.prim1 = prim1;
	}

	public Primitive getPrim2() {
		return prim2;
	}

	public void setPrim2(Primitive prim2) {
		this.prim2 = prim2;
	}

	public String toString() {
		return "{Relation " + type + ": " + prim1 + " " + prim2 + "}";
	}

}
