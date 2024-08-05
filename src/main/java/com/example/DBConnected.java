package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//dbconnectionへ接続するクラス（データベースへの接続）
public class DBConnected {
	

	private static final String URL = "jdbc:postgresql://localhost:5432/dbconnection";
	private static final String USER = "hogeuser";
	private static final String PASSWORD = "hoge";

	/**
	 * データベースへ接続するためのメソッド
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		System.out.println("Connecting to database: URL=" + URL + ", USER=" + USER);//test
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
