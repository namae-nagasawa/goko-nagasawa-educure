package jp.co.example.service;

import java.util.List;

import jp.co.example.controller.form.UserForm;
import jp.co.example.entity.User;

public interface UserService {

	public List<User> findAll();

	public List<User> search(UserForm form);
	
	public List<User> search2(UserForm form);

	public int insert(UserForm form);

}
