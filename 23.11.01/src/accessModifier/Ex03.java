package accessModifier;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Human[] arr = new Human[5];
		Scanner sc = new Scanner(System.in);
		
		// setter 대입 , getter 출력
		
		// 5번 입력 받아서 객체 생성하고 배열에 넣기
		for(int i = 0; i < 5; i++) {
			// arr[i]는 처음에는 빈칸(null)이기 때문에 객체를 먼저 만들어야 한다
			if(i % 2 == 0) {	// 짝수번째에만 입력받기
				
			arr[i] = new Human();
			
			// 이름과 나이를 변수에 입력받고, 입력받은 값을 setter를 활용하여 객체에 넣는다
			System.out.println("이름입력 :");
			String name = sc.next();
			System.out.println("나이입력 :");
			int age = sc.nextInt();
			arr[i].setName(name);	// setter
			arr[i].setAge(age);		//setter
			}
		}
		System.out.println("===입력완료===");
		System.out.println("===출력시작===");
		
		
		
		//배열의 내용을 출력하기
		for(int i = 0; i < arr.length; i++) {	// getter		 getter
			if(arr[i] != null) {	// i번째 칸이 빈칸이 아니면 /null 대상이 있냐 업냐 신경쓰기
									// arr에는 Human타입의 데이터만 들어갈 수 있으므로
									// 빈칸이 아니면, Human 타입의 객체가 있다는 이야기다				
			System.out.printf("%s : %d살\n", arr[i].getName(), arr[i].getAge());
			}
		}
		System.out.println("===출력완료===");
		
		sc.close();
		
		
		
		
		
		
		
		
	}
}
