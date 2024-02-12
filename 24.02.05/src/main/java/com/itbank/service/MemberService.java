package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;

	public List<MemberDTO> getMemberList() {
		return dao.selectList();
	}

	public MemberDTO getMember(int idx) {
		return dao.selectOne();
	}

	public MemberDTO getLogin(MemberDTO dto) {
		
		return dao.login(dto);
	}

	public int add(MemberDTO dto) {
		
		return dao.insert(dto);
	}
}
