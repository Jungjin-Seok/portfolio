package function;

import javax.security.auth.Subject;

public class Ex02 {
	// 1)
	static int add(int n1, int n2) {
			
	return n1 = n2 ;	
	}
	
	
	// 2)
	static int getMinNumber(int n1, int n2, int n3){
		int min = 99999;
		
		if(n1 < min) {
			min = n1;
		}
		if(n2 < min) {
			min = n2;
		}
		if(n3 < min) {
			min = n3;
		}		
		
		return min;	
		}
	
	
	// 3)
	static String upperCase(String str) {
		String answer = "";
		for(int i = 0; i < str.length();  i++) {			
			char ch = str.charAt(i);						
			if(i == 0 && 'a' <= ch && ch <= 'z') { // 첫글자가 소문자이면
				ch -= 32; 		// 대문자로 바꿔라
			}
			answer += ch;  		// i번째 글자(ch)를 answer에 순서대로 더한다
		}
		return answer;
	}
	
	
	// 4)
	static String substring(String str, int from, int to) {
		String answer = "";
//		for(int i = 0; i < str.length(); i++) {					//  index number (0,5) Hello    (7,12) world
//			char ch = str.charAt(i);
//			if(i == 0 && 0 <= i && i < 5 || i == 0 && 7 <= i && i < 12) {				
//				answer += ch; 
//	 } 
//			return answer;	
// }
		for(int i = from; i < to; i++) {		// 7, 12(7, 8, 9, 10, 11)
			answer += str.charAt(i);		
			}
		
		return  answer;
				
	}
	
	
	
	public static void main(String[] args) {
		// 1)두 정수의 덧셈을 반환하는 함수 add를 작성하세요
		int answer = add(10,20);
		System.out.println("answer : " + answer);
		
		
		// 2) 세 정수를 전달받아서 가장 작은 수를 반환하는 함수 getMinNumber를 작성하세요
		
		int q2 = getMinNumber(15, 23, 9);
		System.out.println("q2 :" + q2);
		
		// 3) 문자열 하나를 전달 받아서, 첫글자를 대문자로 변환하는 함수 upperCase를 작성하세요
		String q3 = upperCase("hello");
		System.out.println("q3 :" + q3);
		
		String t3 =  upperCase("3 years later");
		System.out.println("t3: " + t3);
		
		
		// 4) 문자열 하나와 정수 두개를 전달받아서
		// 문자열의 form번째 글자부터 to글자 이전까지의 글자를 잘라낸
		// 새로운 문자열을 반환하는 함수 substring을 작성하세요
		String q4 = substring("Hello, world!!", 0, 5);
		System.out.println("q4 : " + q4);   // Hello
		
		String t4 = substring("Hello, world!!", 7, 12);
		System.out.println("t4 : " + t4);	// World
		
		
		// 5)
		
	}
}
