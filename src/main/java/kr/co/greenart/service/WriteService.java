package kr.co.greenart.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
import kr.co.greenart.model.DellInfo;
import kr.co.greenart.model.InflowInfo;
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

	@Override
	public List<ClassInfo> classTotal(int userPk) {
		// TODO Auto-generated method stub
		return dao.classTotal(userPk);
	}
	// 이상민 고객의 최근 구매 날짜
	@Override
	public String buyDate(int date) {
		// TODO Auto-generated method stub
		return dao.buyDate(date);
	}

	@Override
	public int lookId(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.lookId(user);
	}

	@Override
	public int infoDelet(int pk) {
		// TODO Auto-generated method stub
		return dao.infoDelet(pk);
	}

	@Override
	public int addDelet(int pk) {
		// TODO Auto-generated method stub
		return dao.addDelet(pk);
	}

	@Override
	public int idCheck(int pk) {
		// TODO Auto-generated method stub
		return dao.idCheck(pk);
	}

	@Override
	public ClassInfo userClass(int userPk) {
		// TODO Auto-generated method stub
		return dao.userClass(userPk);
	}

	@Override
	public int Update(ClassInfo info, int userPk) {
		
		return dao.Update(info,userPk);
	}
	
	//검색창에서 이상민 이름을 검색하면 검색한 이름의 게시글만 보여주기
	@Override
	public List<UserInfo> nameFind(String userName) {
		// TODO Auto-generated method stub
		return dao.nameFind(userName);
	}

	@Override
	public List<DellInfo> dellView() {
		// TODO Auto-generated method stub
		return dao.dellView();
	}

	@Override
	public List<DellInfo> dateView(String star, String end) {
		// TODO Auto-generated method stub
		return dao.dateView(star, end);
	}

	@Override
	public int totalCost(String start, String end) {
		// TODO Auto-generated method stub
		return dao.totalCost(start, end);
	}

	@Override
	public int totalRound(String start, String end) {
		// TODO Auto-generated method stub
		return dao.totalRound(start,end);
	}

	@Override
	public List<InflowInfo> totalInflow(String star, String end) {
		// TODO Auto-generated method stub
		return dao.totalInflow(star, end);
	}

	@Override
	public int inflowBlog(String startDate,String endDate,String blog) {
		// TODO Auto-generated method stub
		return dao.inflowBlog(startDate,endDate,blog);
	}

	@Override
	public int inflowInstar(String startDate,String endDate,String instar) {
		// TODO Auto-generated method stub
		return dao.inflowInstar(startDate,endDate,instar);
	}

	@Override
	public int inflowFaceBook(String startDate,String endDate,String face) {
		// TODO Auto-generated method stub
		return dao.inflowFaceBook(startDate,endDate,face);
	}

	@Override
	public int inflowFriend(String startDate,String endDate,String data) {
		// TODO Auto-generated method stub
		return dao.inflowFriend(startDate,endDate,data);
	}

	@Override
	public int inflowother(String startDate,String endDate,String data) {
		// TODO Auto-generated method stub
		return dao.inflowother(startDate,endDate,data);
	}

	
	



}
