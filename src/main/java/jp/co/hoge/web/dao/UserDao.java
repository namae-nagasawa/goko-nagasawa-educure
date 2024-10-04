package jp.co.hoge.web.dao;

import java.util.List;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.controller.form.loginForm;
import jp.co.hoge.web.entity.User;

public interface UserDao {

	public List<User> loginIdName(loginForm form);
	
	public List<User> selectNameTel(UserForm form);
	
	public List<User> selectName(UserForm form);
	
	public List<User> selectTel(UserForm form);
	
	public List<User> selectAll();
	
	public List<User> selectRole();
	
	public List<User> selectId(UserForm form);
	
	public int insert(UserForm form);
}
