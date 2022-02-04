package kr.co.greenart.model;

public class JoinInfo {
	
	private int id;
	private String userId;
	private String password;
	private String name;
	private String phone;
	
	
	
	
	
	public JoinInfo() {	}

	public JoinInfo(int id, String userId, String password, String name, String phone) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "JoinInfo [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", phone="
				+ phone + "]";
	}

	

	
	
	
}
