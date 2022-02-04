package kr.co.greenart.model;

public class ClassInfo {
	private String className;
	private String classDate;
	private int classRound;
	private int cost;
	private String classContent;
	private int memberId;
	
	public ClassInfo() {
		
	}

	public ClassInfo(String className, String classDate, int classRound, int cost, String classContent, int memberId) {
		super();
		this.className = className;
		this.classDate = classDate;
		this.classRound = classRound;
		this.cost = cost;
		this.classContent = classContent;
		this.memberId = memberId;
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

	@Override
	public String toString() {
		return "ClassInfo [className=" + className + ", classDate=" + classDate + ", classRound=" + classRound
				+ ", cost=" + cost + ", classContent=" + classContent + ", memberId=" + memberId + "]";
	}
	
	
	


	
	
}
