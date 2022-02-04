package kr.co.greenart.model;

public class LoginInfo {

	private int id;
	private String userId;
	private String password;
	private String name;
	
	
	
	public LoginInfo() {
		
	}



	public LoginInfo(int id, String userId, String password, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
	}


	public LoginInfo(int id, String userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}

	



	

	
	
}
