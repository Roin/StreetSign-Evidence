package model;

import java.util.ArrayList;

public class Sign {

	private Relation rel;
	private Sign onTopOf;
	private String signType;
	private double plausibility;
	private double belief;

	public Sign(Relation rel, String signType, double belief,
			double plausibility) {
		this.rel = rel;
		this.signType = signType;
		this.plausibility = plausibility;
		this.belief = belief;
	}

	public Relation getRel() {
		return rel;
	}

	public void setRel(Relation rel) {
		this.rel = rel;
	}

	public Sign getOntopof() {
		return onTopOf;
	}

	public void setOntopof(Sign ontopof) {
		this.onTopOf = ontopof;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public double getPlausibility() {
		return plausibility;
	}

	public void setPlausibility(double plausibility) {
		this.plausibility = plausibility;
	}

	public double getBelief() {
		return belief;
	}

	public void setBelief(double belief) {
		this.belief = belief;
	}

	public void generateRelation(ArrayList<Relation> relations, ArrayList<Sign> signs) {
		for (Relation onTopRel : relations) {
			// Check if this Sign is in an on top relation
			if (onTopRel.getType().equalsIgnoreCase("on top") && (rel.getPrim1() == onTopRel.getPrim1() || rel.getPrim2() == onTopRel.getPrim1())) {
				for(Sign sign : signs)
				{
					// Check if there is another sign in this on top relation
					if(onTopRel.getPrim2() == sign.getRel().getPrim1() || onTopRel.getPrim2() == sign.getRel().getPrim2())
						onTopOf = sign;
				}
				
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Schildtyp: " + signType + ".\n");
		sb.append("Glaube: " + belief + ".\n");
		sb.append("Plausibilität: " + plausibility + ".\n");
		sb.append("prim1: " + rel.getPrim1().getId() + "\nprim2: "
				+ rel.getPrim2().getId() + "\n");
		sb.append("Befindet sich mit einer Glaubwürdigkeit von 0,8 über "
				+ ((onTopOf != null) ? ("dem " + onTopOf.getSignType())
						: ("keinem weiteren Schild")) + ".\n");

		return sb.toString();
	}

}
