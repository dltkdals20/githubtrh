package kr.co.greenart.model;

public class CostInfo {
	private int cost;

	public CostInfo() {
		super();
	}

	public CostInfo(int cost) {
		super();
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "CostInfo [cost=" + cost + "]";
	}
	
	
}
