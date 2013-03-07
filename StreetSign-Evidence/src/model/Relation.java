package model;

public class Relation {
	private final String[] primTypes = { "kr", "ks", "de", "ra", "re" };

	private String type;
	private Primitive prim1;
	private Primitive prim2;

	private Solution solution;

	public Relation() {
	}

	public void calculateEvidence() {
		prim1.calcEvidence();
		prim2.calcEvidence();

		solution = new Solution(prim1.getEvTable(), prim2.getEvTable());
		// System.out.println("Relation Solution:" + type + " "+prim1.getId()
		// +","+ prim2.getId());
		// System.out.println(solution);
	}

	public Solution getSolution() {
		return solution;
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

	public Sign generateSign() {
		if (type.equalsIgnoreCase("inside")) {
			String signType;
			String maxType = "unkown";
			double maxValue = 0.0;

			for (String type : primTypes) {
				double pl = solution.getPlausibility(type);
				if (pl > maxValue) {
					maxValue = pl;
					maxType = type;
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

			return new Sign(this, signType, maxValue);
		} else
			return null;
	}

}
