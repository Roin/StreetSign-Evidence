package model;

import java.util.ArrayList;

/**
 * <b>Description of the Cell class</b> <br>
 * Used as a cell of an evidence table. Offers functionality to add and retrieve
 * values of a cell of an evidence table.
 * 
 * @author Watnuss
 * 
 */
public class Cell {

	private double probability;
	private ArrayList<String> intersection;

	/**
	 * <b>Description of Cell()</b><br>
	 * Constructor of Cell class.
	 */
	public Cell() {
		intersection = new ArrayList<String>();
	}

	/**
	 * <b>Description of getProbability()</b><br>
	 * Gets the probability of this Cell.
	 * 
	 * @return Probability
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * <b>Description of setProbability(double probability)</b><br>
	 * Sets the probability of this Cell.
	 * 
	 * @param probability
	 *            Probability
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}

	/**
	 * <b>Description of getIntersectionAsString()</b><br>
	 * Gets the intersection of this Cell. <br>
	 * <br>
	 * <b>!!! Care: For our use-case we only have single elemented sets. For
	 * more generic usage this class has to be adapted !!!</b><br>
	 * 
	 * @return Intersection of this Cell as String
	 */
	public String getIntersectionAsString() {
		if (intersection.isEmpty())
			return " ";
		else
			// temporarily, as there is always just one element
			return intersection.get(0);
	}

	/**
	 * <b>Description of addIntersection(String element)</b><br>
	 * Adds an element to the set of elements.
	 * 
	 * @param element
	 *            Element to be added
	 */
	public void addIntersection(String element) {
		intersection.add(element);
	}

	public String toString() {
		return (intersection.isEmpty()) ? "{ }" : "{ " + intersection.get(0)
				+ " } / " + probability;
	}

}
