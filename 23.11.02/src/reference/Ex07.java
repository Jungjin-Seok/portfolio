package reference;

import java.util.Arrays;

public class Ex07 {
	public static void main(String[] args) {
		Integer n1 = 10, n2 = 20;
		boolean flag1 = n1 - n2 > 0;				// n1 > n2
		
		String s1 = "Hello", s2 = "World";
		boolean flag2 = s1.compareTo(s2) > 0;		// s1 > s2
		
		System.out.printf("n1이 n2보다 크다 :", flag1);
		System.out.printf("s1이 s2보다 크다 :", flag2);
		
		System.out.println("n1이 n2보다 크다 :" + !flag1);
		System.out.println("s1이 s2보다 크다 :" + ! flag2);
		
		// String 클래스의  compareTo(String anotherString)은
		// 두개의 문자열의  글자의 코드값을 비교하여 정수로 반환한다
		
//		 A : 65   Z : 90
		
		Integer[] arr = {50, 30, 20, 40, 10};
		String[] arr2 = {"원빈", "현빈", "우빈", "준빈", "다빈"};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		
		sortIntArray(arr);
		sortStringArray(arr2);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		
		System.out.println();
		
		// arr배열을 정렬한다. 내부 요소를 a와 b라고 할때, b에서 a를 뺀 결과가 정수이다
		// 정수가 0보다 크면 바꿔라
		Arrays.sort(arr, (a, b) -> b - a);	// int는 클래스가 아니라서, Integer로 변경
		System.out.println(Arrays.toString(arr));
		// arr2배열을 정렬한다. 내부요소를 a와 b라고 할때, b와 a를 비교한 결과가 정수로 나타난다
		//정수가 0보다 크면 바꿔라
		Arrays.sort(arr2, (a, b) -> b.compareTo(a));
		System.out.println(Arrays.toString(arr2));
	
}	// end of main
	
	
	// 정수배열을 오름차순으로 정렬하는 함수 sortIntArray(int[] arr)
		static void sortIntArray(Integer[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			for(int j = 0; j < arr.length; j++ ) {		
//				if(arr[i] < arr[j]){
				if(arr[i] - arr[j] < 0) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j]= tmp;
				}
			}
			
		}
	}
	// 문자열배열을 오름차순으로 정렬하는 함수 sortStringArray(String[] arr)
	static void sortStringArray(String[] arr2) {
		for(int i = 0; i < arr2.length; i++) {
			for(int k = 0; k < arr2.length; k++) {
//				if(arr2[i] < arr2[k]){
				if(arr2[i].compareTo(arr2[k]) < 0) {
					String tmp = arr2[i];
					arr2[i] = arr2[k];
					arr2[k] = tmp;	
				}
			}
		}
	}
}	
		
	
		
		
	

