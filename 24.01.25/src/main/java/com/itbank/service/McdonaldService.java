package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.repository.McdonaldDAO;


enum McDonaldCategory{
	all(null),
	burger("버거"),
	drink("음료");
	
	private String columnValue;
	
	McDonaldCategory(String columnValue){
		this.columnValue = columnValue;
	}
	public String getColumnName() {
		return columnValue;
	}
}



@Service
public class McdonaldService {
	
	@Autowired private McdonaldDAO dao;
	
	
//	public List<McdonaldDTO> getMcdonaldList() {
//		List<McdonaldDTO> list = dao.selectList();
//		return list;
//	}


	public List<McdonaldDTO> getMcdonaldSearchList(HashMap<String, String> paramMap) {
		List<McdonaldDTO> list = dao.searchList(paramMap);
		return list;
	}


	public int add(McdonaldDTO dto) {
		int row = dao.insert(dto);
		return row;
	}


//	public List<McdonaldDTO> getMcdonaldCategory(String category) {
//		List<McdonaldDTO> list = dao.selectCategory(category);
//		return list;
//	}
//-----------------------------------------------------------------------	
	public List<McdonaldDTO> getMcdonaldCategory(String category) {
		String columnValue = null;
//		swich(category){
//		case  "all" 	:	colnmnValue = null 	break;
//	    case  "burger"	:	colnmnValue = "버거"	break;
//		case  "drink"	"	colnmnValue = "음료"	break;
//		}	
		McDonaldCategory e1 = McDonaldCategory.valueOf(category);
		columnValue = e1.getColumnName();
		System.out.println("category" + category);
		System.out.println("columnValue" + columnValue);
		System.out.println();
		return dao.selectCategory(columnValue);
	}


	public McdonaldDTO selectOne(int idx) {
		
		return dao.selectOne(idx);
	}
}
