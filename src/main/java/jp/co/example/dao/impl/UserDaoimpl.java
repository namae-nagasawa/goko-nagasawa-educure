package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@Repository
public class UserDaoimpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_SELECTALL="SELECT id,name, price FROM products";
	private final String SQL_SELECT_NAME_PRICE="SELECT id,name,price FROM products WHERE name =? OR price=?";
	private final String SQL_INSERT="INSERT INTO products(id, name, price) VALUES (nextval('products_seq'), ?, ?)";

	public List<User> findAll() {
		return jdbcTemplate.query(SQL_SELECTALL, new BeanPropertyRowMapper<User>(User.class));
	}

	public List<User> search(String name, int price) {
		return jdbcTemplate.query(SQL_SELECT_NAME_PRICE,new BeanPropertyRowMapper<User>(User.class), name, price);
	}

	public int register(String name, int price) {
		return jdbcTemplate.update(SQL_INSERT,name, price);//updateは成功したら1が返ってくるからint型で設定
	}
}
