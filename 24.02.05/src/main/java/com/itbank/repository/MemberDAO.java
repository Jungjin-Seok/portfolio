package com.itbank.repository;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;


@Repository
public interface MemberDAO {

	@Select("select * from member order by idx desc")
	List<MemberDTO> selectList();

	@Select("select * form member where idx = #{idx}")
	MemberDTO selectOne();

	@Select("select * from member where userid = #{userid} and userpw = #{userpw}")
	MemberDTO login(MemberDTO dto);

	@Insert("insert into member (userid, userpw, username, email, gender) values (#{userid}, #{userpw}, #{username}, #{email}, #{gender})")
	int insert(MemberDTO dto);

	
	
	

}
