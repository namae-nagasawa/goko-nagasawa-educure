package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.User;

public interface UserService {

	public List<User> findAll();

	public List<User> search(String name,int price);

	public int register(String name,int price);

}
