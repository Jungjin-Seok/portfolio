package oop;

import java.util.Scanner;

class TV{
	// TV의 속성을 필드로 작성하세요
	// 전원, 채널, 볼륨 그 외 필요하다고 생각하는 필드를 자유롭게 작성하세요
	
	// TV의 기능을 메서드로 정의하세요
	// [전원 on/off], [채널올림/내림], [볼륨올림/내림], [TV상태 출력], [음소거 on/off]
	// 채널은 일정 범위안에서 cycle 형식으로 순환되어야 합니다
	// 음소거는 한번 누르면 볼륨이 0이 되었다가 다시 누르면 원래 볼륨으로 복구되어야 합니다
	// 대부분의 기능은 전원이 켜져있는 상태에서만 작동해야 합니다
	
	// 생성자에서 객체 생성 시 초기값을 지정하세요
	// 매개변수로 받지 않아도 초기값을 지정할 수 있습니다
	// 예를 들면 채널의 초기값이 0인것은 이상합니다. 다른 값이 초기값이 되도록 하세요
	boolean power;
	boolean channel;
	boolean vol;
	boolean sound;
	
	
}



public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TV tv = new TV();
		int menu;
		
		
		
Loop : while(true) {
			System.out.println("");
			System.out.println("");
			System.out.println("선택 >>>");
			menu = sc.nextInt();
			switch(menu) {
			// 입력된 메뉴에 따라서 tv객체의 매서드를 호출하는 형태로 진행
			case  4:				
				tv.channelDown();
				break;
			
			case 6:
				tv.channelUp();
				break;
				
			case 8:
				tv.volUp();
				break;
			
			case 2:
				tv.volDown();
				break;
			
			case 5:
				tv.sound();
				break;
				
			case 0:// 전원 on/off
				tv.power();
				break Loop;
			}
		}
	
		sc.close();
		System.out.println("프로그램 종료");
	
	
	}
	
}
