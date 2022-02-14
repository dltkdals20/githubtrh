package kr.co.greenart.model;

public class BuyInfo {
	private String name;
	private String count;
	public BuyInfo() {
		super();
	}
	public BuyInfo(String name, String count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BuyInfo [name=" + name + ", count=" + count + "]";
	}
	
	
	
}
