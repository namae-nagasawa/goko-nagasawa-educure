package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.User;

public interface UserDao {
	public List<User> findAll();

	public List<User> search(String name,int price);

	public int register(String name,int price);
}
