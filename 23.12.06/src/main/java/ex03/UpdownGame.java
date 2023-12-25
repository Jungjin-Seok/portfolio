package ex03;

import java.util.Random;

public class UpdownGame {
	Random ran = new Random();
	int cpu = ran.nextInt(100) + 1;
	int count = 0;
	
	// 파라미터를 문자열로 전달 받아서 결과 메시지를 반환하는 함수
	public String handle(String param) {
		int user = Integer.parseInt(param);
		String msg = "";
		count++;
	
		if(user == cpu) 		msg = String.format("정답. %d회 만에 정답을 맞춤",count);
		else if(user < cpu) 	msg = "UP (" + count + "회)";
		else if(user > cpu) 	msg = "DOWN (" + count + "회)";
		
		return msg;
	}
	
	
	
	// 시도횟수를 0으로 초기화하고, 랜덥값을 새로 준비하는 함수
	public void reset() {
		count = 0;
		cpu = ran.nextInt(100) + 1 ;
	}	
}