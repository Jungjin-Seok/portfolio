package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.service.McdonaldService;

@Controller
public class McdonaldController {

	@Autowired private McdonaldService ms;
	
//	@GetMapping("/list")
//	public ModelAndView selectList() {
//		ModelAndView mav = new ModelAndView("list");
//		
//		List<McdonaldDTO> list = ms.getMcdonaldList();
//
//		mav.addObject("list", list);
//		
//		return mav;
//	}
	
	@GetMapping("/list/{category}")
	public ModelAndView	selectCategory(@PathVariable("category")String category) {
		ModelAndView mav = new ModelAndView("list");
		List<McdonaldDTO> list = ms.getMcdonaldCategory(category);
		mav.addObject("list", list);
		return mav;
	}
	
	
	@PostMapping("/list")
	public ModelAndView searchList(@RequestParam HashMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("list");
		
		List<McdonaldDTO> list = ms.getMcdonaldSearchList(paramMap);
		
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	@GetMapping("/list/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("list");
		McdonaldDTO dto = ms.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	
	@GetMapping("/list/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("add");
		return mav;
	}
	
	@PostMapping("/list/add")
	public ModelAndView add(McdonaldDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = ms.add(dto);
		return mav;
	}
	
//	@GetMapping("/delete/{idx}")
//	public ModelAndView delete(@PathVariable("idx") int idx) {
//		ModelAndView mav = new ModelAndView("");
//		int row = ms.delete(idx);
//		return mav;
//	}
}
