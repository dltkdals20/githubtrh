package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.InflowInfo;
import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

@Repository
public class YearCountDao implements lYearCountSerivceDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//2022% 총 금액
	@Override
	public int totalCost(String date) {
		return jdbcTemplate.queryForObject("SELECT sum(cost) FROM classInfo where class_date like'"+date+"%'",int.class);
	}
	//2022% 총 고객수
	@Override
	public int totalmember(String dates) {
		System.out.println("data값은요?" + dates);
		return jdbcTemplate.queryForObject("select count(name) from userinfo where date like  '"+dates+"%'",int.class);
		//return jdbcTemplate.queryForObject("select count(name) from userinfo where date like '"+'?'+"%'",int.class, dates);
	}
	//2022% 총 거래수
	@Override
	public int totalRound(String date) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT count(class_date) FROM classInfo where class_date like '"+date+"%'",int.class);
	}
	

	@Override
	public List<InflowInfo> totalInflow(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inflowBlog(String date,String blog) {
		try {
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like '"+date+"%'\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, blog);
		}catch (NullPointerException e){
			
			}
			return 0;
	}

	@Override
	public int inflowInstar(String date,String instar) {
		try {
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like '"+date+"%'\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, instar);
		}catch (NullPointerException e){
			
			}
			return 0;
	}

	@Override
	public int inflowFaceBook(String date,String face) {
		try {
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like '"+date+"%'\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, face);
		}catch (NullPointerException e){
			
			}
			return 0;
	}
	@Override
	public int inflowFriend(String date,String friend) {
		try {
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like '"+date+"%'\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, friend);
		}catch (NullPointerException e){
			
			}
			return 0;
	}

	@Override
	public int inflowother(String date,String other) {
		try {
			return jdbcTemplate.queryForObject("select\r\n"
					+ "COUNT(inflow) as cont\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like'"+date+"%'\r\n"
					+ "group BY inflow\r\n"
					+ "having inflow =?", int.class, other);
		}catch (NullPointerException e){
			
			}
			return 0;
	}

	@Override
	public int experinceCustomer(String date, int data) {
		try {	
			return jdbcTemplate.queryForObject("select count(1) from(\r\n"
					+ "select\r\n"
					+ "name ,COUNT(name) as a\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like'"+date+"%' \r\n"
					+ "group BY name\r\n"
					+ "having a = ?) b", int.class,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}

	@Override
	public int buyCustomer(String date, int data, int dats) {
		try {	
			return jdbcTemplate.queryForObject("select count(1) from(\r\n"
					+ "select\r\n"
					+ "name ,COUNT(name) as a\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like'"+date+"%' \r\n"
					+ "group BY name\r\n"
					+ "having a > ? and a <= ?) b", int.class,data,dats);
		}catch (NullPointerException e){
			
		}
		return 0;
	}

	@Override
	public int starinceCustomer(String date, int data) {
		try {	
			return jdbcTemplate.queryForObject("select count(1) from(\r\n"
					+ "select\r\n"
					+ "name ,COUNT(name) as a\r\n"
					+ "from userInfo\r\n"
					+ "inner join classinfo on userInfo.id = classInfo.memberId\r\n"
					+ "where class_date like'"+date+"%' \r\n"
					+ "group BY name\r\n"
					+ "having a >= ?) b", int.class,data);
		}catch (NullPointerException e){
			
		}
		return 0;
	}

	

}
