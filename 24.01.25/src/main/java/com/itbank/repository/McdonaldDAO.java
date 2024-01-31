package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.mcdonald.McdonaldDTO;

@Repository
public interface McdonaldDAO {

	@Select("select * from mcdonald order by idx")
	List<McdonaldDTO> selectList();

	
	
	@Select("select * from mcdonald"
		  + " where"
		  + " ${searchType} '%' #{searchKeyword} '%' "
		  + " order by idx")
	List<McdonaldDTO> searchList(HashMap<String, String> paramMap);


	@Insert("insert into mcdonald (category, name, price, memo, imgname)"
			+ "values (#{category}, #{name}, #{price}, #{memo}, #{imgname})")
	int insert(McdonaldDTO dto);


//	@Select("select * from mcdonald where category = #{category} order by idx")
//	List<McdonaldDTO> selectCategory(String category);

// 동적
	@Select("<script>"
			+ "select * from mcdonald"
			+ " <if test=\"category != null\">"
			+ " where"
			+ " category = #{category}"
			+ " </if>"
			+ " order by idx "
			+ "</script>")
	List<McdonaldDTO> selectCategory(String category);


	
	
	@Select("select * from mcdonald where idx = #{idx}")
	McdonaldDTO selectOne(int idx);

}
