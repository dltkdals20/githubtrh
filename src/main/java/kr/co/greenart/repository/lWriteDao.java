package kr.co.greenart.repository;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
import kr.co.greenart.model.DellInfo;
import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.UserInfo;

public interface lWriteDao {
	//회원정보 입력
	int add(UserInfo user,int userPk);
	
	//회원정보 불러오기
	List<UserInfo> UserInfolook(int page);
	
	//총페이지 갯수 다오문
	int total();
	
	//회원정보 세부에서 회원정보 이름,나이 불러오기
	UserInfo UserNameAndAge(int id);
	
	//이름과 나이를 이용해서 id 값을 가져오는 서비스
	int lookId(UserInfo user);
	
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
	
	// 이상민 고객의 최근 구매 날짜
	public String buyDate(int date);
	
	//memberInfo 삭제 하는 쿼리
	public int infoDelet(int pk);

	//memberAdd 삭제 하는 쿼리
	public int addDelet(int pk);
	
	//classInfo에 해당 아이디값에 대한 값이 있는지 확인
	public int idCheck(int pk);

	//이상민 이름 클릭했을때 이상민의 수업들었던 해당 수업만 이름,내용 금액등을 보여주기
	public ClassInfo userClass(int userPk);
	
	//이상민 이름 클릭했을때 이상민의 수업들었던 해당 수업만 이름,내용 금액등을 수정하기
	public int Update(ClassInfo info,int userPk);
	
	//검색창에서 이상민 이름을 검색하면 검색한 이름의 게시글만 보여주기
	public List<UserInfo> nameFind(String userName);
	
	//메뉴창에서 거래 탭을 누르게 되면 나오게 되는 데이터
	public List<DellInfo> dellView();
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터
	public List<DellInfo> dateView(String star,String end);
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 금액
	public int totalCost(String start,String end);
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 횟수
	public int totalRound(String start,String end);
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 유입경로 데이터
	public List<InflowInfo> totalInflow(String star,String end);
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 블로그 데이터
	public int inflowBlog(String startDate,String endDate,String blog);
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 인스타 데이터
	public int inflowInstar(String startDate,String endDate,String instar);
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 페이스북 데이터
	public int inflowFaceBook(String startDate, String endDate,String face);
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 지인 데이터
	public int inflowFriend(String startDate,String endDate,String data);
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 기타 데이터
	public int inflowother(String startDate,String endDate,String data);
	
	//경험고객 데이터
	int experinceCustomer(String star, String end, int data);
	//구매고객 데이터
	int buyCustomer(String star, String end, int data,int dats);
	//단골고객 데이터
	int starinceCustomer(String star, String end, int data);
		
	
}
