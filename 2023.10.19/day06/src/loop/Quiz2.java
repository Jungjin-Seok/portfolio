package loop;

import java.util.Random;
import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		
		// 가능하다면 순서도를 먼저 그리고 시작하기
		
		Random ran = new Random();
		Scanner scanner = new Scanner(System.in);
		int answer = ran.nextInt(100) + 1;
		int user;
		int count = 0;

		
/*		
			// 반복을 수행하면서
			while(true) {
			// 사용자에게 값을 입력 받고
			System.out.println("정수 입력 :");
			user = scanner.nextInt();
		
			// 만약 정답이 입력값보다 작으면 Down
			if(answer < user) System.out.println("down");
		
			//     정답이 입력값보다 크면 up
			else if(answer > user) System.out.println("up");
	
			//	   일치하면 반복을 중단
			else //if(answer == user)		break;
		
			//반복할때마다 횟수를 증가
			 count++
		
			// 반복이 끝나면 정답과 횟수를 출력하고 종료
			System.out.printf("정답은 %d, 횟수는 %d", user, count);
			scanner.close();
			
*/			
		
		
		
		
		while(true) {
			System.out.println("정답을 입력하세요 :");
			user = scanner.nextInt();
			count++;
			
			if(answer != user) {
				
				if(answer > user) {
					System.out.println("UP");
			}
				
				else {        						// if( answer < user)
					System.out.println("Down");
			}				
		}
			
			
			else {									// if(answer == user)
				System.out.printf("정답입니다 횟수는 %d회 입니다", count);
				break;
			}							
						
		}
	
		
		scanner.close();
		
		
		
		
	}
}
