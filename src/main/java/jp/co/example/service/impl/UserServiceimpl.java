package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.controller.form.UserForm;
import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;
import jp.co.example.service.UserService;

@Service
@Transactional
public class UserServiceimpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> findNameAndPrice(UserForm form) {
		return userDao.findNameAndPrice(form);
	}
	
	public List<User> findName(UserForm form){
		return userDao.findName(form);
	}
	
	public List<User> findPrice(UserForm form){
		return userDao.findPrice(form);
	}
	
	
	
	public int insert(UserForm form) {
		return userDao.insert(form);
	}

}
