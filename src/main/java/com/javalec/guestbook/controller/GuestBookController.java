package com.javalec.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.service.IGuestBookService;
import com.javalec.guestbook.vo.GuestBookVO;

@Controller
public class GuestBookController {
	@Autowired
	private IGuestBookService guestbookService;
	
	@RequestMapping("/list.do")
	public String getGuestBookList(GuestBookDAO dao, Model model) {
		System.out.println("리스트 조회 컨트롤러입니다.");
		model.addAttribute("list", guestbookService.getGuestBookList());
		return "index.jsp";
	}

	@RequestMapping("/add.do")
	public String addGuestBook(GuestBookDAO dao, GuestBookVO vo) {
		System.out.println("입력 컨트롤러!!");
		guestbookService.insertGuestBook(vo);
		//dao.insert(vo);
		return "list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteGuestBook(GuestBookDAO dao, GuestBookVO vo) {
		System.out.println("삭제 컨트롤러!!");
		dao.delete(vo);
		return "list.do";
	}
}
