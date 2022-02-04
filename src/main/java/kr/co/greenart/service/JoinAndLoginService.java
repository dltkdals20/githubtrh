package kr.co.greenart.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.repository.JoinAndLoginDao;

@Service
public class JoinAndLoginService implements IJoinAndLoginService{
	public static int pickId;

	@Autowired
	private JoinAndLoginDao dao;
	
	@Override
	public int add(JoinInfo user) {
		// TODO Auto-generated method stub
		return dao.add(user);
	}

	@Override
	public boolean logincheck(LoginInfo u, HttpSession session) {
		boolean result = dao.logincheck(u);
		if(result) { //true�� ��� ���ǿ� ���
			LoginInfo vo2 = viewMember(u);
			//���� ���� ���
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getName());
			session.setAttribute("id", vo2.getId());
			pickId = vo2.getId();
		}
		return result;
	}

	@Override
	public LoginInfo viewMember(LoginInfo vo) {
		
		return dao.viewMember(vo);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

}
