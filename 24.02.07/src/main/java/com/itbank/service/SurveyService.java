package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.SurveyDTO;
import com.itbank.repository.SurveyDAO;

@Service
public class SurveyService {

	@Autowired private SurveyDAO dao;

	private String saveDirectiory = "c:\\upload";
	
	private SurveyService() {
		// 스피링 빈이 생성 될 때 (=서버가 시작될 때) saveDirectory 경로를 체크하고 없으면 새로 만든다
		File dir = new File(saveDirectiory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	
	public List<SurveyDTO> getList() {
		return dao.selectList();
	}

	public SurveyDTO getSurvey(int idx) {
		return dao.selectOne(idx);
	}

	public int add(SurveyDTO dto) {
		
		String image1 = dto.getUpload1().getOriginalFilename();
		String image2 = dto.getUpload2().getOriginalFilename();
				
		File F1 = new File(saveDirectiory, image1);
		File F2 = new File(saveDirectiory, image2);
		
		try {
			dto.getUpload1().transferTo(F1);
			dto.getUpload2().transferTo(F2);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
 		
		dto.setImage1(image1);
		dto.setImage2(image2);
	
		return dao.insert(dto);
	}
}
