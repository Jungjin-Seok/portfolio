package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;


@Controller
public class MemberController {

	@Autowired private MemberService ms;
	
	@GetMapping("/member/list")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("/member/{idx}")
	public ModelAndView member(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/list/{idx}");
		MemberDTO dto = ms.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
		
	}
	
	@GetMapping("/member/login")
	public void login() {}
	
	@PostMapping("/member/login")
	public String login(MemberDTO dto, HttpSession session) {
		MemberDTO login = ms.getLogin(dto);
		System.out.println(login != null ? "성공" : "실패" );
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("/member/join")
	public void join() {}
	
	@PostMapping("/member/join")
	public String join(MemberDTO dto) {
		int row = ms.add(dto);
		System.out.println(row != 0 ? "가입성공" : "가입실패");
		return "redirect:/member/login";
	}
	
	
	
	
}
