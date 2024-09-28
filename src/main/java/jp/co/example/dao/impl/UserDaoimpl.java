package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.controller.form.UserForm;
import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@Repository
public class UserDaoimpl implements UserDao {
	
	private final String SELECT="SELECT id,name, price FROM products";
	private final String SELECT_NAME_PRICE="SELECT id,name,price FROM products WHERE name = :userName AND price= :userPrice";
	private final String INSERT="INSERT INTO products(id,name, price) VALUES (nextval('products_seq'), :userName, :userPrice)";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate1;
	
	public List<User> findAll() {
		String sql =SELECT;
	    
        return jdbcTemplate1.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public List<User> search(UserForm form) {
		String sql=SELECT_NAME_PRICE;
        BeanPropertySqlParameterSource parameterSource =new BeanPropertySqlParameterSource(form); //formを使うことによってで自動でデータを入れてくれる。入力したnameもpriceも
       
        return jdbcTemplate.query(sql, parameterSource,new BeanPropertyRowMapper<User>(User.class));
		
	}
	
	public int insert(UserForm form) {
		String sql = INSERT;
		
		 MapSqlParameterSource param = new MapSqlParameterSource();//自分で挿入したいデータを指定する場合
	       
		 	param.addValue("userName", form.getUserName());
		    param.addValue("userPrice", form.getUserPrice());//%を使うとき（ワイルドカード）にaddValueを使うことが多い
		 
	        return jdbcTemplate.update(sql, param); 
		
	}
	
}
//引数sql文、二つ目が挿入するもの）