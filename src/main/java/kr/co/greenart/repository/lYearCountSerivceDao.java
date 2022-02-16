package kr.co.greenart.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

public interface lYearCountSerivceDao {
	
	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 금액
	public int totalCost(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 횟수
	public int totalRound(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 유입경로 데이터
	public List<InflowInfo> totalInflow(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 블로그 데이터
	public int inflowBlog(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 인스타 데이터
	public int inflowInstar(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 페이스북 데이터
	public int inflowFaceBook(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 지인 데이터
	public int inflowFriend(String date);

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 기타 데이터
	public int inflowother(String date);

	// 경험고객 데이터
	int experinceCustomer(String date, int data);

	// 구매고객 데이터
	int buyCustomer(String date, int data, int dats);

	// 단골고객 데이터
	int starinceCustomer(String date, int data);
}
