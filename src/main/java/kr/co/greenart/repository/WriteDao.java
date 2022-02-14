package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.ClassInfo;
import kr.co.greenart.model.CostInfo;
import kr.co.greenart.model.DellInfo;
import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.UserInfo;

@Repository
public class WriteDao implements lWriteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 회원정보 입력
	@Override
	public int add(UserInfo user, int userPk) {
		String query = "INSERT INTO UserInfo(name,age,date,content,joinmember)" + "VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(query, user.getName(), user.getAge(), user.getDate(), user.getContent(), userPk);
	}

	@Override
	public List<UserInfo> UserInfolook(int page) {
		int a  = (page-1)*10;
		System.out.println("페이지 a이는 요?" + a);
		return jdbcTemplate.query("SELECT id,name,date,content FROM userinfo ORDER BY ID DESC limit 10 offset ?", new ListInfoRowMappers(),a);

		// ListInfoRowMapper를 Autowired 로 쓰는것도 고려해봅시당
	}

	private class ListInfoRowMappers implements RowMapper<UserInfo> {
		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String date = rs.getString("date");
			String content = rs.getString("content");
			return new UserInfo(id, name, date, content);
		}
	}
	//토탈페이지 보여주는 다오
	@Override
	public int total() {
		return jdbcTemplate.queryForObject("select count(*) from userInfo", int.class);
	}

	// 이름과 나이를 이용해서 id 값을 가져오는 서비스
	@Override
	public int lookId(UserInfo user) {
		return jdbcTemplate.queryForObject("SELECT id FROM userinfo where name= ?  and age= ?", int.class,
				user.getName(), user.getAge());
	}

	@Override
	public UserInfo UserNameAndAge(int id) {
		return jdbcTemplate.queryForObject("SELECT name, age FROM userinfo where id =? ", new RowMapper<UserInfo>() {
			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new UserInfo(rs.getString("name"), rs.getInt("age"));
			}
		}, id);
	}

	// 거래 등록
	@Override
	public int ClassInfoAdd(ClassInfo info, int userId) {
		String query = "INSERT INTO classinfo(class_name,class_date,class_round,cost,inflow,content,memberId)"
				+ "VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(query, info.getClassName(), info.getClassDate(), info.getClassRound(),
				info.getCost(), info.getInflow(), info.getClassContent(), userId);
	}

	// 이상민 고객이 쓴 총 금액을 가져옴.
	@Override
	public int totalCost(int userInfo) {
		try {
			return jdbcTemplate.queryForObject("SELECT sum(cost)FROM classinfo where  memberId= ?", int.class,
					userInfo);
		} catch (NullPointerException e) {

		}
		return 0;
	}
	// 2022년에 수업을 2번이상 구매한 사람들은 몇명인가요?
	// 이상민 고객이 신청한 총 횟수를 가져옴.
	@Override
	public int totalRound(int userInfo) {

		return jdbcTemplate.queryForObject("SELECT count(class_round)FROM classinfo where  memberId= ?", int.class,
				userInfo);
	}

	// 이상민 이름 클릭했을때 이상민의 수업들었던 이름,날짜,횟수 내용을 보여주기
	@Override
	public List<ClassInfo> classTotal(int userPk) {
//		int a  = (page-1)*5;
		return jdbcTemplate.query(
				"select id, class_name, class_date,class_round,cost,inflow,content from classinfo where memberId =? ",
				new ClassInfoRowMappers(), userPk);
	}

	private class ClassInfoRowMappers implements RowMapper<ClassInfo> {
		@Override
		public ClassInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String class_name = rs.getString("class_name");
			String class_date = rs.getString("class_date");
			int class_round = rs.getInt("class_round");
			int cost = rs.getInt("cost");
			String inflow = rs.getString("inflow");
			String content = rs.getString("content");
			return new ClassInfo(id, class_name, class_date, class_round, cost, inflow, content);
		}
	}

	// 이상민 고객의 최근 구매 날짜
	@Override
	public String buyDate(int date) {

		return jdbcTemplate.queryForObject(
				"SELECT class_date FROM (select * from classInfo where(memberId,class_date)in(\r\n"
						+ "		select memberId, max(class_date) as class_date\r\n"
						+ "        from classInfo group by memberId having memberId = ?\r\n" + "        )\r\n"
						+ "        order by class_date desc\r\n" + "        )t\r\n" + "        group by t.memberId",
				String.class, date);
	}

	// classInfo에 해당 아이디값에 대한 값이 있는지 확인
	@Override
	public int idCheck(int pk) {
		return jdbcTemplate.queryForObject("select count(*) from classInfo where memberId = ?", int.class, pk);
	}

	// memberInfo 삭제 하는 쿼리
	@Override
	public int infoDelet(int pk) {
		String query = "delete from classInfo where memberId = ?";
		return jdbcTemplate.update(query, pk);
	}

	// userInfo문에 있는 id 값 삭제 memberAdd
	@Override
	public int addDelet(int pk) {
		String query = "delete from userInfo where id = ?";
		return jdbcTemplate.update(query, pk);
	}

	// 이상민 이름 클릭했을때 이상민의 수업들었던 해당 수업만 이름,내용 금액등을 보여주기
	@Override
	public ClassInfo userClass(int userPk) {
		return jdbcTemplate.queryForObject(
				"select class_name, class_date,class_round,cost,inflow,content from classinfo where id =? ",
				new ClassInfoRowMapperss(), userPk);
	}

	private class ClassInfoRowMapperss implements RowMapper<ClassInfo> {
		@Override
		public ClassInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String class_name = rs.getString("class_name");
			String class_date = rs.getString("class_date");
			int class_round = rs.getInt("class_round");
			int cost = rs.getInt("cost");
			String inflow = rs.getString("inflow");
			String content = rs.getString("content");
			return new ClassInfo(class_name, class_date, class_round, cost, inflow, content);
		}

	}

	// 고객 세부목록 수정하는 쿼리문
	@Override
	public int Update(ClassInfo info, int pk) {
		Date date = new Date();
		String query = "update classInfo set class_name = ?, class_date = ?, class_round =? ,cost = ? ,inflow = ?, content =?  where id = ?";
		return jdbcTemplate.update(query, info.getClassName(), info.getClassDate(), info.getClassRound(),
				info.getCost(), info.getInflow(), info.getClassContent(), pk);
	}

	@Override
	public List<UserInfo> nameFind(String userName) {
		return jdbcTemplate.query("select id, name, date,content from userInfo where name =? ",
				new UserInfofoRowMapper(), userName);
	}

	private class UserInfofoRowMapper implements RowMapper<UserInfo> {
		@Override
		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String date = rs.getString("date");
			String content = rs.getString("content");
			return new UserInfo(id, name, date, content);
		}

	}

	@Override
	public List<DellInfo> dellView() {
		return jdbcTemplate.query(
				"select\r\n" + " name, class_name,class_date,class_round,cost,inflow\r\n" + "from userInfo\r\n"
						+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n" + "order by class_date desc",
				new DellInfoRowMapperss());
	}

	private class DellInfoRowMapperss implements RowMapper<DellInfo> {
		@Override
		public DellInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			String class_name = rs.getString("class_name");
			String class_date = rs.getString("class_date");
			int class_round = rs.getInt("class_round");
			int cost = rs.getInt("cost");
			String inflow = rs.getString("inflow");
			return new DellInfo(name, class_name, class_date, class_round, cost, inflow);
		}
	}

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터
	@Override
	public List<DellInfo> dateView(String star, String end) {
		return jdbcTemplate.query(
				"select\r\n" + " name, class_name,class_date,class_round,cost,inflow\r\n" + "from userInfo\r\n"
						+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
						+ "where class_date between ? and ?\r\n" + "order by class_date desc",
				new DateInfoRowMapperss(), star, end);
	}

	private class DateInfoRowMapperss implements RowMapper<DellInfo> {
		@Override
		public DellInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String name = rs.getString("name");
			String class_name = rs.getString("class_name");
			String class_date = rs.getString("class_date");
			int class_round = rs.getInt("class_round");
			int cost = rs.getInt("cost");
			String inflow = rs.getString("inflow");
			return new DellInfo(name, class_name, class_date, class_round, cost, inflow);
		}
	}

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 금액
	@Override
	public int totalCost(String start, String end) {
		try {
		return jdbcTemplate.queryForObject("select\r\n" + " sum(cost)\r\n" + "from userInfo\r\n"
				+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
				+ "where class_date between ? and ?\r\n" + "order by class_date desc;", int.class, start, end);
	}catch(NullPointerException e){
		}
		return 0;
	}

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 횟수
	@Override
	public int totalRound(String start, String end) {
		return jdbcTemplate.queryForObject("select\r\n" + " count(class_round)\r\n" + "from userInfo\r\n"
				+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
				+ "where class_date between ? and ?\r\n" + "order by class_date desc", int.class, start, end);
	}

	// 메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 총 유입경로 데이터
	@Override
	public List<InflowInfo> totalInflow(String star, String end) {

		return jdbcTemplate.query(
				"select\r\n" + " inflow ,COUNT(inflow) as count\r\n" + "from userInfo\r\n"
						+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
						+ "where class_date between ? and ?\r\n" + "group BY inflow;",
				new InflowRowMapperss(), star, end);
	}

	private class InflowRowMapperss implements RowMapper<InflowInfo> {
		@Override
		public InflowInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			String inflow = rs.getString("inflow");
			String count = rs.getString("count");
			System.out.println("inflow 값"+inflow);
			System.out.println("cont 값"+count);
			return new InflowInfo(inflow, count);
		}
	}
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 블로그 데이터
	@Override
	public int inflowBlog(String startDate, String endDate,String blog) {
		try {
		return jdbcTemplate.queryForObject("select\r\n"
				+ "COUNT(inflow) as cont\r\n"
				+ "from userInfo\r\n"
				+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
				+ "where class_date between ? and ?\r\n"
				+ "group BY inflow\r\n"
				+ "having inflow =?", int.class, startDate,endDate,blog);
	}catch (NullPointerException e){
		
		}
		return 0;
	}
	
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 인스타 데이터
	@Override
	public int inflowInstar(String startDate, String endDate,String instar) {
		try {
		return jdbcTemplate.queryForObject("select\r\n"
				+ "COUNT(inflow) as cont\r\n"
				+ "from userInfo\r\n"
				+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
				+ "where class_date between ? and ?\r\n"
				+ "group BY inflow\r\n"
				+ "having inflow =?", int.class, startDate,endDate,instar);
	}catch (NullPointerException e){
		}
		return 0;
	}
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 페이스북 데이터
	@Override
	public int inflowFaceBook(String startDate, String endDate,String face) {
		try {		
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, startDate,endDate,face);
		}catch (DataAccessException e){
			return 0;
		}
		
	}
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 지인 데이터
	@Override
	public int inflowFriend(String startDate, String endDate,String data) {
		try {	
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, startDate,endDate,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}
	//메뉴창에서 거래 탭을 누르고 날짜 선택 후 나오는 데이터 중 기타 데이터
	@Override
	public int inflowother(String startDate, String endDate,String data) {
		try {	
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, startDate,endDate,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}
	
	//경험고객 데이터
	@Override
	public int experinceCustomer(String star, String end, int data) {
		System.out.println("!!!!!!!!!!!!!!!!!!!"+star);
		System.out.println("!!!!!!!!!!!!!!!!!!!"+end);
		System.out.println("!!!!!!!!!!!!!!!!!!!"+data);
		try {	
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(name) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "and class_round = ?", int.class, star,end,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}
	//구매고객 데이터
	@Override
	public int buyCustomer(String star, String end, int data, int dats) {
		try {	
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(name) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "and class_round >= ? and class_round < ?", int.class, star,end,data,dats);
		}catch (NullPointerException e){
			
		}
		return 0;
	}
	//단골고객 데이터
	@Override
	public int starinceCustomer(String star, String end, int data) {
		try {	
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(name) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date between ? and ?\r\n"
					+ "and class_round <= ?", int.class, star,end,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}



}
