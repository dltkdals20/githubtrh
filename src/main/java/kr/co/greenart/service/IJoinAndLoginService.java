package kr.co.greenart.service;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginService {

	//회원가입
	int add(JoinInfo user);
	//회원 로그인 체크
	boolean logincheck(LoginInfo u, HttpSession seesion );
	//회원 로그인 정보
	public LoginInfo viewMember(LoginInfo vo);
	//회원 로그아웃
	public void logout(HttpSession session);
	
	
}
