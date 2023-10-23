package string;

public class Ex03 {
	public static void main(String[] args) {
		
		String s1 = "a1B2c3D4e5";
		String filter = "abcdefgABCDEFG";
		String s2 = " ";	// 정수 덧셈에 대한 항등원이 0이라면
							// 문자열 덧셈에 대한 항등원은 ""이다 (아무것도 더하지 않았을때의 값)
		
		for(int i = 0; i < s1.length(); i++) { 		// 전체 글자 중에서							
			char ch = s1.charAt(i);					// 각 글자를 ch라고 핼때						
			String s = ch + "";						// contains 함수에는 문자열을 전달해야 한다
			if(filter.contains(s)) {				// 필터가 글자를 포함하면(글자가 필터에 포함되면)
				s2 += s; 							// 결과에 포함시킨다								
			}
			
		}
		System.out.println("s2 : " + s2);
	}
}
