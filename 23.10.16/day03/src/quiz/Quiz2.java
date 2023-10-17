package quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		// 친구와 고기집에 갔다
		// 이 식당에서는 첫 주문에 최소 3인분을 주문해야하고
		// 이후에는 1인분씩 추가가 가능하다
		// [돼지고기 삼겹살 1인분이 8500원]이고
		// [소주1병(4500원)], [맥주1병(5000원']을 고정으로 주문했다
		// [추가 주문한 삼겹살 양]을 입력받아서 <- 여기가 입력 받아야 할 값
		// [총 결제해야 할 급액]을 계산하고
		// [더치페이로 1인당 얼마를 내야 하는지] 계산하여 출력하는 프로그램을 작성하세요

		int gogi = 8500, sj = 4500, mj = 5000;
		int add;		// 추가 주문한 삼겹살의 양(인분)
		int total;  	// 총 금액
		int divide;  	// 더치페이 했을 때의 금액
		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.print("추가 주문한 삼겹살 양(인분) :  \r" );
		add = sc.nextInt();
		
		
		total = (gogi * add) + sj + mj;
		divide = total / 2;
		
		System.out.printf("총 결제해야 할 금액은 %d이고\r\r더치페이 할 금액은 %d입니다",
				total, divide);
		
		sc.close();
		
	}
}
