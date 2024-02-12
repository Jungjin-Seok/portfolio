package com.itbank.service;

import org.springframework.stereotype.Service;

import com.itbank.utils.Exp;



@Service
public class ex01Service {

	// 0으로 나누었을 때의 예외가 발생하면, 직접 처리하지 않고, Caller에게 예외처리를 전가시킨다
	// 1) 예외 발생 유형과 원인을 파악해야 한다
	// 2) 컨트롤러 하위의 스프링빈에서는 예외를 전가시켜서 컨트롤러까지 도달시킨다
	public int calc(int n1, String operator ,int n2) throws ArithmeticException {
		int answer = 0;
//		if(operator.equals("+")) {
//			answer = n1 + n2;
//		}else if (operator.equals("-")) {
//			answer = n1 - n2;
//		}else if (operator.equals("*")) {
//			answer = n1 * n2;
//		} else {
//			answer = n1 / n2;
//		}
		
		
//		switch(operator) {
//		case "+" : answer = n1 + n2; break;
//		case "-" : answer = n1 - n2; break;
//		case "*" : answer = n1 * n2; break;
//		case "/" : answer = n1 / n2; break;
//		
//		}
		
		// 바뀐점
		// 분기문을 사용 하였으나 , Exp에서는 사용x
		// 특정 범위의 값만 사용이 가능하다 (+, -, *, /)에서 만약 %가 있다면 예외 발생
		Exp oper = Exp.valueOf(operator); // PLUS, MINUS, MULTI, DIVIDE
		answer = oper.getAnswer(n1, n2);
		
		// 만들어진 객체를 참조하여 불러온다 (카테고리 분류), 상수 처리하기 위함
		System.out.println(Exp.PLUS);
		System.out.println(Exp.MINUS);
		System.out.println(Exp.MULTI);
		System.out.println(Exp.DIVIDE);
		
		return answer;
	}

	
	
	
}
