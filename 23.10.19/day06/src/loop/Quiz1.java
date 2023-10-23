package loop;

public class Quiz1 {
	public static void main(String[] args) {
		
		// 1) 자신의 이름을 5회 반복하여 출력하세요
		int num = 5;
		while(num < 10) {
			System.out.println("정진석");
			num++;
		}
		System.out.println();
		
		// 2) 0부터 5까지 출력하세요
		int num1 = 0;
		while(num1 <= 5) {
			System.out.print(num1);
			num1++;
		}
		System.out.println();
		
		// 3) 5부터 0까지 출력하세요
		int num2 = 5;
		while(num2 >= 0) {
			System.out.print(num2);
			num2--;
	    }
		System.out.println();
		
		
		// 4) 1부터 100까지의 합계를 구하여 출력하세요
		int sum = 0;
		int i = 1;
		while(i < 101) {
			sum += i;		 //	+= 누적 더하기
			i++;
		}
		System.out.println("1부터 100까지의 합계 : " + sum +"\n");
		
		
		// 5) 1부터 100사이의 정수 중, 7의 배수만 한줄에 출력하세요
		i = 1;
		while(i < 101) {						// 숫자를 반복하여 증가시킬 조건
			if(i % 7 == 0) {					// 변화하는 숫자의 값이 7로 나누어 진다
				System.out.println(i + " ");
			}
			i++;
		}
		System.out.println();
		
		i = 7;									// 초기값 변경
		while(i < 101) {						// 조건은 그대로
			System.out.println(i + " ");
			i += 7;								// 7씩 증가하기 때문에 if를 쓰지 않아도 된다
		}
		System.out.println();
		
		
	}	// end of main
}	// end of class
