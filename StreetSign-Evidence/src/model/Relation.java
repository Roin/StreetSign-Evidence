package model;

/**
 * <b>Description of the Relation class</b> <br>
 * Contains the data about a given relation. Contains a reference to the
 * solution of the relation. Contains a reference to a sign, if this relation
 * results in a sign.
 * 
 * @author Watnuss
 * 
 */
public class Relation {
	private final String[] primTypes = { "kr", "ks", "de", "ra", "re" };

	private String type;
	private Primitive prim1;
	private Primitive prim2;

	private Solution solution;

	/**
	 * <b>Description of calculateEvidence()</b> <br>
	 * Determines the evidence table of the two given primitives of this
	 * relation and generates an accumulated evidence table out of the two
	 * primitives.
	 */
	public void calculateEvidence() {
		prim1.calcEvidence();
		prim2.calcEvidence();

		solution = new Solution(prim1.getEvTable(), prim2.getEvTable());
		// System.out.println("Relation Solution:" + type + " "+prim1.getId()
		// +","+ prim2.getId());
		// System.out.println(solution);
	}

	/**
	 * <b>Description of getSolution()</b><br>
	 * Gets the Solution of this Relation.
	 * 
	 * @return The Solution object of this Relation
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * <b>Description of getType()</b><br>
	 * Gets the type of this Relation.
	 * 
	 * @return The type of this Relation
	 */
	public String getType() {
		return type;
	}

	/**
	 * <b>Description of setType(String type)</b><br>
	 * Sets the type of this Relation.
	 * 
	 * @param type
	 *            The type of this Relation
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * <b>Description of getPrim1()</b><br>
	 * Gets the first Primitive of this Relation.
	 * 
	 * @return Primitive 1
	 */
	public Primitive getPrim1() {
		return prim1;
	}

	/**
	 * <b>Description of setPrim1()</b><br>
	 * Sets the first Primitive of this Relation.
	 * 
	 * @param prim1
	 *            The first Primitive
	 */
	public void setPrim1(Primitive prim1) {
		this.prim1 = prim1;
	}

	/**
	 * <b>Description of getPrim2()</b><br>
	 * Gets the second Primitive of this Relation.
	 * 
	 * @return The second Primitive
	 */
	public Primitive getPrim2() {
		return prim2;
	}

	/**
	 * <b>Description of setPrim2()</b><br>
	 * Sets the second Primitive of this Relation.
	 * 
	 * @param prim2
	 *            The second Primitive
	 */
	public void setPrim2(Primitive prim2) {
		this.prim2 = prim2;
	}

	public String toString() {
		return "{Relation " + type + ": " + prim1 + " " + prim2 + "}";
	}

	/**
	 * <b>Description of generateSign()</b><br>
	 * Determines the sign type of the sign with the maximum belief value and
	 * generates a Sign object, if it is found.
	 * 
	 * @return The Sign of maximum belief or <b>null</b> if it was no inside
	 *         relation
	 */
	public Sign generateSign() {
		if (type.equalsIgnoreCase("inside")) {
			String signType;
			String maxType = "unkown";
			double maxBelief = 0.0;
			double pl = 0.0;
			double belief;

			for (String type : primTypes) {
				belief = solution.getBelief(type);
				if (belief > maxBelief) {
					maxBelief = belief;
					maxType = type;
					pl = solution.getPlausibility(type);
				}
			}

			switch (maxType) {

			case "kr":
				signType = "Verbotsschild";
				break;

			case "ra":
				signType = "Vorfahrtsschild";
				break;

			case "de":
				signType = "Achtungsschild";
				break;

			case "re":
			case "ks":
			default:
				signType = "Unbekanntes Schild";
				break;

			}

			return new Sign(this, signType, maxBelief, pl);
		} else
			return null;
	}

}
