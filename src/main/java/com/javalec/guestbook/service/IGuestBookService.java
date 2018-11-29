package com.javalec.guestbook.service;

import java.util.List;

import com.javalec.guestbook.vo.GuestBookVO;

public interface IGuestBookService {

	public void insertGuestBook(GuestBookVO vo);
	public void deleteGuestBook(GuestBookVO vo);
	public List<GuestBookVO> getGuestBookList();
	
	
}
