package kr.co.greenart.service;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface IJoinAndLoginService {

	//ȸ������
	int add(JoinInfo user);
	//ȸ�� �α��� üũ
	boolean logincheck(LoginInfo u, HttpSession seesion );
	//ȸ�� �α��� ����
	public LoginInfo viewMember(LoginInfo vo);
	//ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
	
	
}
