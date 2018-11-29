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
		System.out.println("����Ʈ ��ȸ ��Ʈ�ѷ��Դϴ�.");
		model.addAttribute("list", guestbookService.getGuestBookList());
		return "index.jsp";
	}

	@RequestMapping("/add.do")
	public String addGuestBook(GuestBookDAO dao, GuestBookVO vo) {
		System.out.println("�Է� ��Ʈ�ѷ�!!");
		guestbookService.insertGuestBook(vo);
		//dao.insert(vo);
		return "list.do";
	}

	@RequestMapping("/delete.do")
	public String deleteGuestBook(GuestBookDAO dao, GuestBookVO vo) {
		System.out.println("���� ��Ʈ�ѷ�!!");
		dao.delete(vo);
		return "list.do";
	}
}
