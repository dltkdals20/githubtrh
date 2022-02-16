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

	@Override
	public int totalCost(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalRound(String dates) {
		System.out.println("data값은요?" + dates);
		return jdbcTemplate.queryForObject("select count(name) from userinfo where date like  '"+dates+"%'",int.class);
		//return jdbcTemplate.queryForObject("select count(name) from userinfo where date like '"+'?'+"%'",int.class, dates);
	}

	@Override
	public List<InflowInfo> totalInflow(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inflowBlog(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inflowInstar(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inflowFaceBook(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inflowFriend(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inflowother(String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int experinceCustomer(String date, int data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int buyCustomer(String date, int data, int dats) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int starinceCustomer(String date, int data) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
