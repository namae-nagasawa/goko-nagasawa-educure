package jp.co.example.dao;

import java.util.List;

import jp.co.example.controller.form.UserForm;
import jp.co.example.entity.User;


public interface UserDao {
	public List<User> findAll();

	public List<User> search(UserForm form);

	public int insert(UserForm form);
}
