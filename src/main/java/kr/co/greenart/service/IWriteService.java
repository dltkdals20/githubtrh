package kr.co.greenart.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
import kr.co.greenart.model.DellInfo;
import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.model.UserInfo;

public interface IWriteService {

	int UserAdd(UserInfo user, int userPk);

	// UserInfo에 있는 id,이름,날짜,내용을 가져오기
	List<UserInfo> look();

	// 회원정보 세부사항에서 이름 나이 가져오기
	UserInfo UserNameAndAge(int id);

	// 이름과 나이를 이용해서 id 값을 가져오는 서비스
	int lookId(UserInfo user);

	// 거래등록
	int classInfoAdd(ClassInfo info, int userId);

	// 이상민 총 금액가져오기
	int totalCost(int userInfo);

	// 이상민 총 수업 횟수
	public int totalRound(int userInfo);

	// 이상민 이름 클릭했을때 이상민의 수업들었던 모든 수업 이름,내용 금액등을 보여주기
	public List<ClassInfo> classTotal(int userPk);

	// 이상민 고객의 최근 구매 날짜
	public String buyDate(int date);

	// classInfo에 해당 아이디값에 대한 값이 있는지 확인
	public int idCheck(int pk);

	// memberInfo 삭제 하는 쿼리
	public int infoDelet(int pk);

	// memberAdd 삭제 하는 쿼리
	public int addDelet(int pk);

	// 이상민 이름 클릭했을때 이상민의 수업들었던 해당 수업만 이름,내용 금액등을 보여주기
	public ClassInfo userClass(int userPk);

	// 이상민 이름 클릭했을때 이상민의 수업들었던 해당 수업만 이름,내용 금액등을 수정하기
	public int Update(ClassInfo info, int userPk);

	// 검색창에서 이상민 이름을 검색하면 검색한 이름의 게시글만 보여주기
	public List<UserInfo> nameFind(String userName);

	// 메뉴창에서 거래 탭을 누르게 되면 나오게 되는 데이터
	public List<DellInfo> dellView();

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터
	public List<DellInfo> dateView(String star, String end);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 금액
	public int totalCost(String star, String end);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 횟수
	public int totalRound(String star, String end);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 유입경로
	public List<InflowInfo> totalInflow(String star, String end);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 블로그 데이터
	public int inflowBlog(String star, String end,String blog);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 인스타 데이터
	public int inflowInstar(String star, String end,String instar);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 페이스북 데이터
	public int inflowFaceBook(String star, String end,String face);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 지인 데이터
	public int inflowFriend(String star, String end,String data);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 기타 데이터
	public int inflowother(String star, String end,String data);

}
