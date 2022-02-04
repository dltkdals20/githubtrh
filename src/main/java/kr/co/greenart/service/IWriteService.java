package kr.co.greenart.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.UserInfo;

public interface IWriteService {

	int UserAdd (UserInfo user,int userPk);
	
	List<UserInfo> look();
	
	//회원정보 세부사항에서 이름 나이 가져오기
	UserInfo UserNameAndAge(int id);
	
	//거래등록
	int classInfoAdd(ClassInfo info,int userId);
	
	//이상민 총 금액가져오기
	int totalCost(int userInfo);
	
	//이상민 총 수업 횟수
	public int totalRound(int userInfo);
	
	
}
