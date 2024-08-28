package jp.com.example.dao.impl;

import org.springframework.stereotype.Repository;

import jp.com.example.dao.ProductDao;

@Repository
public class ProductADao implements ProductDao {

	public String find() {
		return "鉛筆";
		
	}
}
