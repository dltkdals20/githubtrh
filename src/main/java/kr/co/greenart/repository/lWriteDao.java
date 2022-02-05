package kr.co.greenart.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.UserInfo;

public interface lWriteDao {
	//회원정보 입력
	int add(UserInfo user,int userPk);
	
	//회원정보 불러오기
	List<UserInfo> UserInfolook();
	
	//회원정보 세부에서 회원정보 이름,나이 불러오기
	UserInfo UserNameAndAge(int id);
	
	//거래 등록
	int ClassInfoAdd(ClassInfo info,int userId);
	
	//이상민 총 금액 가져오기
	int totalCost(int userInfo);
	
	//이상민 총 수업 횟수
	public int totalRound(int userInfo);
	
	//이상민 이름 클릭했을때 이상민의 수업들었던 이름,내용등을 보여주기(금액제외)
	public List<ClassInfo> classTotal(int userPk);
	
//	//이상민 이름 클릭했을때 이상민의 수업들었던 금액을 보여주기
//	public List<CostInfo> classCost(int userPk);
//	
}
