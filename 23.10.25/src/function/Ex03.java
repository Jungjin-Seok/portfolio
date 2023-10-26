package function;

public class Ex03 {
	
	// 두 정수 중에서 가장 큰 수 반환하기
	static int getMaxNum(int n1, int n2) {
		return n1 > n2 ? n1 : n2;
	}
	// 세 정수 중에서 가장 큰 수 반환하기
	static int getMaxNum(int n1, int n2, int n3) {
	int result = 0;
	if(result < n1)  {  
		result = n1;
	}
    if(result < n2) { 	ㄴ
    	result = n2;
    }
	if(result < n3) { 	
		result = n3;
	}
		
		return result; 
	}
	// n개의 정수중에서 가장 큰 값을 반환하기
	static int getMaxNum(int ...arr) {		// 같은 자료형의 여러 매개변수 개수가 일정하지 않을때
											// 가변인자 : 인자(원인이 되는 값)의 개수가 일정하지 않는다(printf)
		
		int result = 0;						
//		for(int i = 0; i < arr.length; i++) {	// 매개변수들을 순서대로 조회하면서
//			int num = arr[i];					// 각 숫자를 num이라고 할 때
//			if(result < num)					// 기존 최대값보다 더 큰 값이 있으면
//				result = num;					// 그 값을 최대값에 담는다
//		}
		for(int num : arr) {		// n개의 정수를 num에 대입한다
			if(result < num) {		// 정의한 result 값이 num 보다 작을때
				result = num;		// num 값을 result 값에 대입한다
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int num1 = getMaxNum(10, 20);
		int num2 = getMaxNum(100, 200, 300);
		int num3 = getMaxNum(1, 2, 3, 4, 5, 60, 700, -8, 99);
		
		// [함수]의 overloding : 함수의 중복 정의 
		
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
			
	}
}
