package com.javalec.guestbook.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javalec.guestbook.util.sqlSessionFactoryBean;
import com.javalec.guestbook.vo.GuestBookVO;


public class GuestBookDAO {

	private SqlSession mybatis;
	
	public GuestBookDAO() {
		mybatis = sqlSessionFactoryBean.getSqlSession();
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
		} catch (Exception e) {
			System.out.println("�ε��ȵ� :" + e);
		}
		return conn;
	}
	
	public void delete(GuestBookVO vo) {
		mybatis.delete("GuestBookDao.delete", vo);
	}
	
	public void insert(GuestBookVO vo ) {
		mybatis.insert("GuestBookDao.insert",vo);
	}
	
	public List<GuestBookVO> getList() {
		return mybatis.selectList("GuestBookDao.getList");
	}
	
	public List<GuestBookVO> getKeywordList(Map<String, Object> map){
		System.out.println("mybatis");
		return mybatis.selectList("GuestBookDao.getKeywordList", map);
		
	}
}
