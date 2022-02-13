package kr.co.greenart.model;

public class DellInfo {
	String name;
	String class_name;
	String class_date;
	int class_round;
	int cost;
	String inflow;
	public DellInfo() {
		super();
	}
	public DellInfo(String name, String class_name, String class_date, int class_round, int cost, String inflow) {
		super();
		this.name = name;
		this.class_name = class_name;
		this.class_date = class_date;
		this.class_round = class_round;
		this.cost = cost;
		this.inflow = inflow;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_date() {
		return class_date;
	}
	public void setClass_date(String class_date) {
		this.class_date = class_date;
	}
	public int getClass_round() {
		return class_round;
	}
	public void setClass_round(int class_round) {
		this.class_round = class_round;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getInflow() {
		return inflow;
	}
	public void setInflow(String inflow) {
		this.inflow = inflow;
	}
	@Override
	public String toString() {
		return "DellInfo [name=" + name + ", class_name=" + class_name + ", class_date=" + class_date + ", class_round="
				+ class_round + ", cost=" + cost + ", inflow=" + inflow + "]";
	}
	
	

}
