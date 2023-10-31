package day13;

import java.util.Random;

public class EX0000 {
	
	static int[] getArr(){			
		int[] arr= new int[6];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(45)+1;			
				for(int k = 0 ; k < i; k++) {			// 중복이 되지 않게 해야함
					if(arr[i] == arr[k] ) {
						i--;
				}								
			}
			
		}
		return arr;
	}
	
	static void show(int arr[]) {						// 출력
		for(int i = 0; i < arr.length; i++) {		
			if(i == 5 ) {
				System.out.printf("%2d ", arr[i]);
			}
			else {
				System.out.printf("%2d, ", arr[i]);
			}
		}	System.out.println();
	}
		
	
	static void selectionSolt(int[] arr) {				// 정렬
		
	for(int i = 0; i < arr.length; i++) {
		for(int j = i + 1; j < arr.length; j++) {
			if(arr[i] > arr[j]) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	  }
	}
	
	public static void main(String[] args) {
		/*
		 	다음 조건을 만족하여 결과를 출력하세요
		 	
		 	- 선택정렬 함수를 만들어야 합니다
		 	- 중복없는 랜덤 정수 6개로 구성된 배열을 반환하는 함수를 만들어야합니다
		 	- (1~45 사이의 랜덤정수)
		 	- 한줄당 6개, 총 5줄의 정수를 출력하는 프로그램을 작성하세요
		 	- 하나의 배열 당 중복된 정수가 사용되면 안됩니다.
		 	 
		 */
		System.out.println("응시자 : 정진석\n");
			
			
		    int[] arr = null;
			for(int i = 0; i < 5; i++) {
				arr = getArr();
				selectionSolt(arr);	
				show(arr);
			}
			
	}
}
