package com.javalec.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

@Service("guestbookService")
public class GuestBookService implements IGuestBookService {
	@Autowired
	private GuestBookDAO dao ;
	
	@Override
	public void insertGuestBook(GuestBookVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void deleteGuestBook(GuestBookVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	@Override
	public List<GuestBookVO> getGuestBookList() {
		// TODO Auto-generated method stub
		
		return dao.getList();
	}

}
