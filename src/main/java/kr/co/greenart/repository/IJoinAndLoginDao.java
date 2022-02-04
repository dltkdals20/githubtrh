package kr.co.greenart.repository;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginDao {
	//회원가입
	int add(JoinInfo user);
	//로그인
	boolean logincheck(LoginInfo u);
	//ȸ�� �α��� ����
	public LoginInfo viewMember(LoginInfo u);
	
	//ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
}
