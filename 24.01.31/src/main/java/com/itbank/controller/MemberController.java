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
@RequestMapping("/member")
public class MemberController {

	@Autowired private MemberService ms;

	@GetMapping("/list") // "/member/list"
	public ModelAndView memberList() {
		// ModelAndView 에서도 viewName을 비워두면 void와 마찬가지로 작동한다
		// 요청한 주소를 구성하는 문자열을 viewName으로 활용한다
		// 따라서 "WEB-INF/views/member/list.jsp"

		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list", list);
		return mav;
	}

	@GetMapping("/{idx}")
	public ModelAndView member(@PathVariable("idx") int idx) {
		// @Pathvariable을 사용한다면 반드시 viewName을 지정한다
		// 요청 주소가 제각각이므로, JSp의 이름을 고정시켜야한다

		ModelAndView mav = new ModelAndView("/member/info");
		MemberDTO dto = ms.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
	}

	@GetMapping("/login")
	public void login() {
	}


	@PostMapping("/login")
	public String login(MemberDTO dto, String url, HttpSession session) {
		MemberDTO login = ms.login(dto);
		session.setAttribute("login", login);
		if(url == null) {
			url = "/";
		}
		return "redirect:" + url;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public void join() {
	}

	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = ms.add(dto);
		System.out.println(row != 0 ? "추가성공" : "추가실패");
		return "redirect:/member/login";
	}

	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = ms.delete(idx);
		System.out.println(row != 0 ? "삭제성공" : "삭제실패");
		return "redirect:/member/list";
	}

	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/modify");
		MemberDTO dto = ms.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
	}

	@PostMapping("/modify/{idx}")
	public String modify(MemberDTO dto) {
//		Mapping 의 {idx}의 DTO의 필드이름과 일치하면 자동으로 값이 입력된다
		System.out.println(dto.getIdx());

		int row = ms.modify(dto);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");

//		return "redirect:/member/" + dto.getIdx();
		return "redirect:/member/{idx}"; // Mapping의 {idx}는 리다이렉트 경로로 사용할 수 있다
	}

	@GetMapping("/resetPass")
	public void resetPass() {}
	
	@PostMapping("/resetPass")
	public ModelAndView resetPass(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		
		String pass = ms.resetPass(dto);
		
		mav.addObject("msg", "변경된 비밀번호는[" + pass + "] 입니다");
		mav.addObject("url", pass != null ? "/member/login" : "");
		
		return mav;
	}
	
	
}
