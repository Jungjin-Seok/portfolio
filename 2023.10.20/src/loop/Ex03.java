package loop;

public class Ex03 {
	public static void main(String[] args) {
		// for문 기본 연습 문제
		
		// 1) 1에서 10사이 정수의 합계를 구하여 출력하세요
		
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i;
		}
		System.out.printf("합계 : %d\n", total);
		
		
		// 2) 11에서 20사이 정수의 합계를 구하여 출력하세요
		total = 0; 
		for(int i = 11; i <= 20; i++) {
			total += i;
		}
		System.out.printf("합계 : %d \n", total);
		
		
		
		// 3) 5에서 0까지 세로로 출력하세요
		
		for(int i = 5; i >= 0 ; i-- ) {
			System.out.printf("i : %d, ",i);
		}
		System.out.println();	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
