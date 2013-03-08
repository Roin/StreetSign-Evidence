package model;

public class Sign {
	
	private Relation rel;
	private Sign ontopof;
	private String signType;
	private double plausibility;
	private double belief;
	
	public Sign(Relation rel, String signType, double belief, double plausibility)
	{
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
		return ontopof;
	}
	public void setOntopof(Sign ontopof) {
		this.ontopof = ontopof;
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

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Schildtyp: " + signType + ".\n");
		sb.append("Glaube: " + belief + ".\n");
		sb.append("Plausibilität: " + plausibility + ".\n");
		sb.append("prim1: " + rel.getPrim1().getId() + "\nprim2: " + rel.getPrim2().getId());
		
		return sb.toString();
	}
	
	

}
