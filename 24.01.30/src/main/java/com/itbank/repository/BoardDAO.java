package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	
	List<BoardDTO> selectList();

	BoardDTO selectOne(int idx);
// resultType  id      parameterType  <select id="selectOne" parameterType="int" resultType="board"> select * from board where idx = #{idx}</select>

	
	int insert(BoardDTO dto);

	
	int delete(int idx);
}
