package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.SurveyDTO;
import com.itbank.service.SurveyService;

@Controller
public class SurveyController {

	@Autowired private SurveyService ss;	
	
	@GetMapping("/survey/list")
	public ModelAndView surveyList() {
		ModelAndView mav = new ModelAndView();
		List<SurveyDTO> list = ss.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/survey/{idx}")
	public ModelAndView survey(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView();
		SurveyDTO dto = ss.getSurvey(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/survey/insert")
	public void join() {}
	
	@PostMapping("/survey/insert")
	public String join(SurveyDTO dto) {
		int row = ss.add(dto);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/survey/list";
	}
	
	
}
