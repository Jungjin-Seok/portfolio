package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itbank.service.UploadService;
import com.itbank.upload1.Upload1DTO;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {

	@Autowired private UploadService service;
	
	// GET, POST 메서드를 구분하고 싶다면 <view-controller> 태그를 쓸 수 없다
	
	@GetMapping
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<Upload1DTO> list = service.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping
	public String ex03(Upload1DTO dto) {
		int row = service.upload(dto);
		System.out.println(row != 0 ? "등록 성공" : "등록 실패");
		return "redirect:/ex03";	// 다시 getMapping으로 돌아가서 화면에 출력한다
		
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx")int idx, RedirectAttributes rttr) {
		int row = service.delete(idx);
		rttr.addFlashAttribute("msg", row != 0 ? "삭제성공" : "삭제실패");
		return "redirect:/ex03";
	}
	
	
}
