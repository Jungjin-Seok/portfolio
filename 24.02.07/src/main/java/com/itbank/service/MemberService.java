package com.itbank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	@Autowired private HashComponent hashComponent;
	
	public List<MemberDTO> getMemberList() {
		return dao.selectList();
	}

	public MemberDTO getMember(int idx) {
		return dao.selectOne();
	}

	public MemberDTO getLogin(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		return dao.login(dto);
	}

	public int add(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		return dao.insert(dto);
	}

	public String resetPass(MemberDTO dto) {
		String newPassword = UUID.randomUUID().toString().replace("-", "").substring(0,6);
		String hash =  hashComponent.getHash(newPassword);
		
		System.out.println("newPassword : " + newPassword);
		System.out.println("hash" + hash);
		
		dto.setUserpw(hash);
		int row = dao.updatePassword(dto);
		
		return row != 0 ? newPassword : null;
	}
}
