package kr.co.greenart.model;

public class InflowInfo {
	private String inflow;
	private String count;
	
	
	public InflowInfo() {
		super();
	}


	public InflowInfo(String inflow, String count) {
		super();
		this.inflow = inflow;
		this.count = count;
	}


	public String getInflow() {
		return inflow;
	}


	public void setInflow(String inflow) {
		this.inflow = inflow;
	}


	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "InflowInfo [inflow=" + inflow + ", count=" + count + "]";
	}
	
	
	
	
}
