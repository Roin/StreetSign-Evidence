package model;

import java.util.ArrayList;

public class Relation {
	private String type;
	private Primitive prim1;
	private Primitive prim2;
	
	private ArrayList<Solution> solutions;
	
	public void calculateEvidence()
	{
		
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
	
	public String toString()
	{
		return "{Relation " + type + ": " + prim1 + " " +  prim2 + "}";
	}

}
