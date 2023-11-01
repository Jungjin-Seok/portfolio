package book;

import java.util.Scanner;

// 사용자와 상호작용(입출력)
// 입력값에 따라서 handler의 함수를 호출


public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		String name;	// 책 이름
		String genre;	// 책 장르
		int price;		// 책 가격
		
		int menu;
		
		while(true) {
			System.out.println("1) 입 력");
			System.out.println("2) 출 력");
			System.out.println("0) 종료");
			System.out.println("선 택 >>>");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu){
				case 1:
					System.out.println("책의 제목 입력");
					name = sc.nextLine();
					System.out.println("책의 장르 입력");
					genre = sc.nextLine();				
					System.out.println("책의 가격 입력");
					price = Integer.parseInt(sc.nextLine());
						break;
				
				case 2:
					break;
		
				case 3:
					break;
				
				case 0:
					break;
		
			}
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
