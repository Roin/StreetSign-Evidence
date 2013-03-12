package model;

import java.util.ArrayList;

/**
 * <b>Description of the Sign class</b> <br>
 * Used to store data about recognized signs such as their belief, plausibility
 * and relation to other recognized signs.
 * 
 * @author Watnuss
 * 
 */
public class Sign {

	private static int counter = 0;

	public final int id;
	private Relation rel;
	private Sign onTopOf;
	private String signType;
	private double plausibility;
	private double belief;

	/**
	 * <b>Description of Sign(Relation rel, String signType, double belief,
	 * double plausibility)</b><br>
	 * Constructor of Sign class.
	 * 
	 * @param rel
	 *            Reference to the inside relation which created this sign
	 * @param signType
	 *            Name of the Sign
	 * @param belief
	 *            Belief with which the sign was created
	 * @param plausibility
	 *            Plausibility of this sign
	 */
	public Sign(Relation rel, String signType, double belief,
			double plausibility) {
		this.id = counter++;
		this.rel = rel;
		this.signType = signType;
		this.plausibility = plausibility;
		this.belief = belief;
	}

	/**
	 * <b>Description of getId()</b><br>
	 * Gets the Id of this Sign.
	 * 
	 * @return The Id of this Sign
	 */
	public int getId() {
		return id;
	}

	/**
	 * <b>Description of getRel()</b><br>
	 * Gets the Relation which generated this Sign.
	 * 
	 * @return Corresponding Relation to this Sign
	 */
	public Relation getRel() {
		return rel;
	}

	/**
	 * <b>Description of getSignType()</b><br>
	 * Gets the name of the Sign.
	 * 
	 * @return Name of the Sign
	 */
	public String getSignType() {
		return signType;
	}

	/**
	 * <b>Description of generateRelation(ArrayList<Relatoin> relaions,
	 * ArrayList<Sign> signs) Checks whether this Sign is part of an "on top"
	 * Relation and if this "on top" Relation contains another valid Sign.
	 * 
	 * @param relations
	 *            ArrayList containing all existing relations
	 * @param signs
	 *            ArrayList containing all existing signs
	 */
	public void generateRelation(ArrayList<Relation> relations,
			ArrayList<Sign> signs) {
		for (Relation onTopRel : relations) {
			// Check if this Sign is in an on top relation
			if (onTopRel.getType().equalsIgnoreCase("on top")
					&& (rel.getPrim1() == onTopRel.getPrim1() || rel.getPrim2() == onTopRel
							.getPrim1())) {
				for (Sign sign : signs) {
					// Check if there is another sign in this on top relation
					if (onTopRel.getPrim2() == sign.getRel().getPrim1()
							|| onTopRel.getPrim2() == sign.getRel().getPrim2())
						onTopOf = sign;
				}

			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Schildtyp: " + signType + " (ID: " + id + ").\n");
		sb.append("Glaube: " + belief + ".\n");
		sb.append("Plausibilitaet: " + plausibility + ".\n");
		sb.append("prim1: " + rel.getPrim1().getId() + "\nprim2: "
				+ rel.getPrim2().getId() + "\n");
		sb.append("Befindet sich mit einer Glaubwuerdigkeit von 0,8 ueber "
				+ ((onTopOf != null) ? ("dem " + onTopOf.getSignType()
						+ " (ID: " + onTopOf.getId() + ")")
						: ("keinem weiteren Schild")) + ".\n");

		return sb.toString();
	}

}
