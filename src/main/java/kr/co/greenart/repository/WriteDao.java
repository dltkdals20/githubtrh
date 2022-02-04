package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.ClassInfo;
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
	public List<UserInfo> UserInfolook() {
		return jdbcTemplate.query("SELECT id,name,date,content FROM userinfo; ", new ListInfoRowMappers());

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
		String query = "INSERT INTO classinfo(class_name,class_date,class_round,cost,content,memberId)"
				+ "VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(query, info.getClassName(), info.getClassDate(), info.getClassRound(),
				info.getCost(), info.getClassContent(), userId);
	}

	// 이상민 고객이 쓴 총 금액을 가져옴.
	@Override
	public int totalCost(int userInfo) {

		return jdbcTemplate.queryForObject("SELECT sum(cost)FROM classinfo where  memberId= ?"
				, int.class, userInfo);
	}
	
	// 이상민 고객이 신청한 총 횟수를 가져옴.
	@Override
	public int totalRound(int userInfo) {

		return jdbcTemplate.queryForObject("SELECT count(class_round)FROM classinfo where  memberId= ?"
				, int.class, userInfo);
	}

}
