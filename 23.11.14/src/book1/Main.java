package book1;

import java.util.Scanner;

public class Main {	// CRUD
	public static void main(String[] args) {
		// Book 클래스의 필드값을 입력받거나 출력을 위해
		// 지역변수를 만들어 두는 편이 좋다
		String name, author, publisher;
		int price;
		
		Book[] arr = new Book[10];
		Scanner sc = new Scanner(System.in);
		int menu;
		
		MAIN: while(true) {
			System.out.println("1.목록");
			System.out.println("2.추가");
			System.out.println("0.종료");
			System.out.println("메뉴 입력 >>>");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu){
			case 1:
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] != null) {
						System.out.printf("%s (%s,%s) : %,d원\n", arr[i].name, arr[i].author, arr[i].publisher, arr[i].price);
					}
				}
				break; //break for switch
			case 2:
				System.out.println("도서 이름 입력 :");
				name = sc.nextLine();
				
				System.out.println("저자 입력 :");
				author = sc.nextLine();
				
				System.out.println("출판사 입력 :");
				publisher = sc.nextLine();

				System.out.println("도서 가격 입력 :");
				price = Integer.parseInt(sc.nextLine());
				
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] == null) {
						arr[i] = new Book();
						arr[i].name = name;
						arr[i].author = author;
						arr[i].publisher = publisher;
						arr[i].price = price;	
						break;	// break for "for"
					}
				}
				break;	// break for switch
				
			case 0:		
				break MAIN;
			}
		System.out.println();
		} // end of while
		sc.close();
		System.out.println("프로그램 종료");
		
	}
}
