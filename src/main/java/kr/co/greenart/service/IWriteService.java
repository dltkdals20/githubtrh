package kr.co.greenart.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
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
	
	//이상민 이름 클릭했을때 이상민의 수업들었던 이름,내용 금액등을 보여주기
	public List<ClassInfo> classTotal(int userPk);
	
//	//이상민 이름 클릭했을때 이상민의 수업들었던 금액을 보여주기
//	public List<CostInfo> classCost(int userPk);
}
