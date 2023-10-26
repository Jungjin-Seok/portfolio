package function;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {
	// 매개 변수가 없는 함수
	static int getDice() { // 1~6사이의 랜덤 정수를 반환하는 함수		// 사용자 함수에서는 자주 사용되거나, 복잡한 코드를 묶어둔다
		
		Random ran = new Random();
		
		int dice = 0;
		dice = ran.nextInt(6) + 1;
		
		return dice;
	}
	
	public static void main(String[] args) { 		// 전체 프로그램의 진행을 작성
		Scanner sc = new Scanner(System.in);		// 메인 함수의 코드만 보고도 대략 어떤 흐름인지 파악할 수 있다
		
		
//		Random ran = new Random();  변수는 해당 지역에서만 유효
		
		int answer;
		int user;
		int cnt = 0;
		
		while(true) {
			answer = getDice();
			System.out.print("주사위 값을 맞춰보세요 : ");
			user = sc.nextInt();		
			cnt++;
			if(answer == user) {
				break;
			}
		}
		System.out.printf("정답입니다. %d회 만에 정답을 맞췄습니다\n" ,cnt);
		sc.close();
		
	}
}
