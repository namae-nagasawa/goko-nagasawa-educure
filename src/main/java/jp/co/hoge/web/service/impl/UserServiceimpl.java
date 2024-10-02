package jp.co.hoge.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.hoge.web.controller.form.UserForm;
import jp.co.hoge.web.entity.User;
import jp.co.hoge.web.service.UserService;

@Service
@Transactional
public class UserServiceimpl implements UserService {

	@Autowired
	private jp.co.hoge.web.dao.UserDao userDao;

	public List<User> loginIdName(UserForm form) {
		return userDao.loginIdName(form);
	}

	public List<User> selectNameTel(UserForm form){
		return userDao.selectNameTel(form);
	}
	public List<User> selectName(UserForm form){
		return userDao.selectName(form);
	}
	public List<User> selectTel(UserForm form){
		return userDao.selectTel(form);
	}
	public List<User> selectAll(){
		return userDao.selectAll();
	}
}
