package kr.co.greenart.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.UserInfo;
import kr.co.greenart.repository.JoinAndLoginDao;
import kr.co.greenart.repository.WriteDao;

@Service
public class WriteService implements IWriteService{

	@Autowired
	private WriteDao dao;
	//회원 추가하는 칸
	@Override
	public int UserAdd(UserInfo user,int userPk) {
		// TODO Auto-generated method stub
		return dao.add(user,userPk);
	}

	@Override
	public List<UserInfo> look() {
		// TODO Auto-generated method stub
		return dao.UserInfolook();
	}
	
	//회원정보 세부사항에서 이름 나이 가져오기
	@Override
	public UserInfo UserNameAndAge(int id) {
		// TODO Auto-generated method stub
		return dao.UserNameAndAge(id);
	}

	//거래등록
	@Override
	public int classInfoAdd(ClassInfo info,int userId) {
		// TODO Auto-generated method stub
		return dao.ClassInfoAdd(info,userId);
	}

	//이상민 총금액 가져오기
	@Override
	public int totalCost(int userInfo) {
		// TODO Auto-generated method stub
		return dao.totalCost(userInfo);
	}
	
	//이상민 총 수업 횟수
	@Override
	public int totalRound(int userInfo) {
		return dao.totalCost(userInfo);
	}
	
	



}
