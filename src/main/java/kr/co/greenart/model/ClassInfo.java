package kr.co.greenart.model;

public class ClassInfo {
	private int id;
	private String className;
	private String classDate;
	private int classRound;
	private int cost;
	private String inflow;
	private String classContent;
	private int memberId;
	private int count;
	
	public ClassInfo() {
		
	}

	public ClassInfo(String className, String classDate, int classRound, int cost,String inflow, String classContent, int memberId) {
		super();
		this.className = className;
		this.classDate = classDate;
		this.classRound = classRound;
		this.cost = cost;
		this.inflow=inflow;
		this.classContent = classContent;
		this.memberId = memberId;
	}
	
	


	public ClassInfo(int id ,String className, String classDate, int classRound, int cost, String inflow, String classContent) {
		super();
		this.id = id;
		this.className = className;
		this.classDate = classDate;
		this.classRound = classRound;
		this.cost = cost;
		this.inflow=inflow;
		this.classContent = classContent;
	}
	
	
	
	public ClassInfo(String className, String classDate, int classRound, int cost, String inflow, String classContent) {
		super();
		this.className = className;
		this.classDate = classDate;
		this.classRound = classRound;
		this.cost = cost;
		this.inflow = inflow;
		this.classContent = classContent;
	}
	
	
	
	
	public ClassInfo(String inflow, int count) {
		super();
		this.inflow = inflow;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInflow() {
		return inflow;
	}

	public void setInflow(String inflow) {
		this.inflow = inflow;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public int getClassRound() {
		return classRound;
	}

	public void setClassRound(int classRound) {
		this.classRound = classRound;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getClassContent() {
		return classContent;
	}

	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public ClassInfo(int id, String className, String classDate, int classRound, int cost, String inflow,
			String classContent, int memberId, int count) {
		super();
		this.id = id;
		this.className = className;
		this.classDate = classDate;
		this.classRound = classRound;
		this.cost = cost;
		this.inflow = inflow;
		this.classContent = classContent;
		this.memberId = memberId;
		this.count = count;
	}



	
	
	
	


	
	
}
