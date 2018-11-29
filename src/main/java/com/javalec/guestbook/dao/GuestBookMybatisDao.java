package com.javalec.guestbook.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.guestbook.vo.GuestBookVO;

@Repository
public class GuestBookMybatisDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	public void insert(GuestBookVO vo) {
		mybatis.insert("GuestBookDao.insert", vo);
	}
	public void delete(GuestBookVO vo) {
		mybatis.delete("GuestBookDao.delete", vo);
	}
	public List<GuestBookVO> getList() {
		return mybatis.selectList("GuestBookDao.getList");
	}
	
	public List<GuestBookVO> getKeywordList(Map<String, Object> map){
		System.out.println("mybatis");
		return mybatis.selectList("GuestBookDao.getKeywordList", map);
	}
}
