package jp.co.hoge.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.dao.UserDao;
import jp.co.hoge.web.entity.User;

@Repository
public class UserDaoimpl implements UserDao {

	private static final String SQL_LOGIN = "SELECT login_id,password,user_id,user_name,telephone,role_id  FROM user_info WHERE login_id = :loginId AND password = :password";

	private static final String SQL_NAME_TEL = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.user_name = :userName AND user_info.telephone = :telephone";

	private static final String SQL_NAME = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.user_name= :userName";

	private static final String SQL_TEL = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.telephone= :telephone";
	
	private static final String SQL_SELECT_ALL = "SELECT user_info.user_id, user_info.login_id, user_info.user_name, user_info.telephone, user_info.password, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id = role.role_id";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate1;

	public List<User> loginIdName(UserForm form) {
		List<User> resultList = new ArrayList<>();
		String sql = SQL_LOGIN;
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("loginId", form.getLoginId());
		param.addValue("password", form.getPassword());

		resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
		return resultList;
	}

	public List<User> selectNameTel(UserForm form) {
		List<User> resultList = new ArrayList<>();
		String sql = SQL_NAME_TEL;
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("userName", form.getUserName());
		param.addValue("telephone", form.getTelephone());

		resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
		return resultList;

	}

	public List<User> selectName(UserForm form) {
		List<User> resultList = new ArrayList<>();
		String sql = SQL_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("userName", form.getUserName());

		resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
		return resultList;
	}
	public List<User> selectTel(UserForm form) {
		List<User> resultList = new ArrayList<>();
		String sql = SQL_TEL;
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("telephone", form.getTelephone());

		resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
		return resultList;
	}
	public List<User> selectAll(){
		String sql =SQL_SELECT_ALL;
		
		return jdbcTemplate1.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}
	
}