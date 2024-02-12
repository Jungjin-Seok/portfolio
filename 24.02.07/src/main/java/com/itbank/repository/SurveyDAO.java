package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.SurveyDTO;

@Repository
public interface SurveyDAO {

	@Select("select * from survey order by idx desc")
	List<SurveyDTO> selectList();

	@Select("select * from survey where idx = #{dix}")
	SurveyDTO selectOne(int idx);

	@Insert("insert into survey (title, question1, question2, image1, image2) values(#{title}, #{question1}, #{question2}, #{image1}, #{image2})")
	int insert(SurveyDTO dto);

	
	

}
	