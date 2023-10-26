package function;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
/*
		RPG게임의 아이템 강화 시뮬레이션
		
		// 아이템을 강화할때 마다 아이템의 레벨이 올라간다
		// 아이템을 강화하는데는 일정량의 게임머니가 소비된다
		// 게임머니는 한정되어 있다
		// 아이템의 레벨이 일정값을 넘어가면 강화 확률이 감소한다
		// 레벨1~레벨5까지는 100%
		// 레벨6 : 90%
		// 레벨7 : 80%
		// 만약, 강화에 실패하면 게임머니는 그대로 소비하지만 아이템의 레벨은 오히려 떨어진다
		// 한정된 게임머니로 누가 제일 높은 레벨까지 도달하는지 겨루는 게임이다
		// 게임머니를 모두 소비하거나, 스스로 중단할 수 있다
		 
		// 총 게임머니 : 10000원, 한번 강화하는데 소비되는 게임머니 : 500원
*/
		
		Scanner sc = new Scanner(System.in);
		int money = 10000;
		int fee = 500;
		int lv = 1;
		int menu;
		boolean flag;
		LOOP : while(true) {
			System.out.println("현재 레벨 : " + lv);
			System.out.printf("현재 머니 : %,d\n",money);
			System.out.println("1.강화");
			System.out.println("0.포기");
			System.out.println("메뉴 선택 >>> ");
			menu = sc.nextInt();
		
			switch(menu) {
			case 1:
				if(money < fee) {
					System.out.println("머니가 부족합니다");
					break LOOP;
				}
				for(int i = 0; i < 3; i++) {
					System.out.println(".");
					try {Thread.sleep(200);} catch(Exception e) {}
				}
				
				flag = enhance(lv); 	// 강화를 시도하고 결과를 반환한다
				money -= fee;		// 강화비용을 받는다
				lv += flag ? 1 : -1;//성공하면 1이 더해지고, 실패하면 -1이 더해진다
				System.out.println(flag ? "강화 성공" : "어이쿠, 손이 미끄러졌네");
				break; 
			
			case 0:
				break LOOP;
			}	
		} // end of while
		System.out.println("최종결과");
		System.out.println("현재 레벨 : " + lv);
		System.out.printf("현재 머니 : %,d\n",money);
		System.out.println("점수 :" + (lv * 1000 + money));
	
		sc.close();
		
	}	// end if main() : 프로그램 실행 시 가장 먼저 실행되는 함수이다
	static boolean enhance(int lv) {
		boolean success = true;
		int successPer;
		Random ran = new Random();
		int a1 = ran.nextInt(100) + 1;
		successPer = 100 - (lv - 4) * 10 ;
				
//			if(lv >= 5) {
//				if(a1 <= successPer) {	
//					success = true;
//					System.out.println("강화성공");
//				}
//				else {	
//					success = false;
//					System.out.println("강화실패");
//				}
//				
//			}
		
			System.out.printf("%d / %d (%s)\n", a1, successPer,a1 <= successPer);
			success = a1 <= successPer;
			
		return success;
	}
}	// end of class	:	main() 혹은 다른 함수들은 모두 calss 내부에 있어야 한다
  

	

