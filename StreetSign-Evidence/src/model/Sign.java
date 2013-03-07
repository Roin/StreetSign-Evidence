package model;

public class Sign {
	
	private Relation rel;
	private Sign ontopof;
	private String signType;
	private double plausibility;
	
	public Sign(Relation rel, String signType, double plausibility)
	{
		this.rel = rel;
		this.signType = signType;
		this.plausibility = plausibility;
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
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Schildtyp: " + signType + ".\n");
		sb.append("Plausibilität: " + plausibility + ".\n");
		sb.append("prim1: " + rel.getPrim1().getId() + "\nprim2: " + rel.getPrim2().getId());
		
		return sb.toString();
	}
	
	

}
