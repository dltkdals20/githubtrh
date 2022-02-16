package kr.co.greenart.service;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginService {


	int add(JoinInfo user);

	boolean logincheck(LoginInfo u, HttpSession seesion );

	public LoginInfo viewMember(LoginInfo vo);

	public void logout(HttpSession session);
	
	
}
