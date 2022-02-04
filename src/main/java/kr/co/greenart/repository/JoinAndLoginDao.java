package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;

@Repository
public class JoinAndLoginDao implements IJoinAndLoginDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//회원가입 
	@Override
	public int add(JoinInfo user) {
		String query = "INSERT INTO JOINTABLE(userId,password,name,phone)"
				+"VALUES(?,?,?,?)";
		return jdbcTemplate.update(query, user.getUserId(),user.getPassword(),user.getName(),user.getPhone());
	}

	//로그인
	@Override
	public boolean logincheck(LoginInfo u) {
		
		return jdbcTemplate.queryForObject("select count(*) from jointable where userid = ? and password =?", boolean.class,u.getUserId(),u.getPassword());
	}

	//�α��� ������
	@Override
	public LoginInfo viewMember(LoginInfo u) {
		return jdbcTemplate.queryForObject("select id, userId , name from jointable where userid = ? and password =?"
				,new RowMapper<LoginInfo>() {

					@Override
					public LoginInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return new LoginInfo(rs.getInt("id"),rs.getString("userId"),rs.getString("name"));
					}},u.getUserId(),u.getPassword());
	}


	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

}
