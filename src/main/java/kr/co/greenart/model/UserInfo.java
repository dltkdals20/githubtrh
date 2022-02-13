package kr.co.greenart.model;

public class UserInfo {
	int id;
	String name;
	int age;
	String date;
	String content;
	public UserInfo() {
		super();
	}
	public UserInfo(String name, int age, String date, String content) {
		super();
		this.name = name;
		this.age = age;
		this.date = date;
		this.content = content;
	}
	
	

	public UserInfo(int id, String name, int age, String date, String content) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.date = date;
		this.content = content;
	}
	public UserInfo(int id, String name, String date, String content) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.content = content;
	}
	
	

	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + ", content=" + content
				+ "]";
	}
	
	
	
	
	
}
