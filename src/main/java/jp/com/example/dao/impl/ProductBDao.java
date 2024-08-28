package jp.com.example.dao.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import jp.com.example.dao.ProductDao;

@Repository
@Primary
public class ProductBDao implements ProductDao {

	public String find() {
		return "消しゴム";
	}
}
