package jp.com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.example.dao.ProductDao;
import jp.com.example.service.ProductService;

@Service
public class DefaultProductService implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	
	public String find() {
		return productDao.find();
	}
}
