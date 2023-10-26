package function;

import java.util.Arrays;

// 주어진 배열에서 가장 등장빈도가 많은 값을 구하세요
// 가장 많이 등장한 값의 횟수가 아니라, 값 그 자체를 반환해야 합니다
// 최빈값이 2개 이상이면 -1을 반환해야 한다

// 0 < array의 길이 < 100
// 0 < array의 원소 < 1000

class Solution {
	public int solution(int[] array) {
		int answer = 0;
		
		// 원소의 최대값을 먼저 구하고, 그 길이만큼의 배열을 생성하여 횟수체크에 사용한다
		// 이 과정을 생략하고 싶다면 길이 1001의 배열을 생성하면 된다
		// +1이 들어가는 이유은 0부터 시작하는 index의 특성상 계산이 번거로워져서
		int max = 0;
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		int[] counts = new int[max +1]; // {0,0,0,0,0,0,0,0...,0,0,0}
		
		
		// 1) array 내부 숫자의 등장 빈도를 counts에 기록하기
		
		for(int i = 0; i < array.length; i++) {
			int num = array[i];
			counts[num] += 1;
			
		}
//		System.out.println(Arrays.toString(counts));
//		System.out.println(Arrays.toString(array));
			
		
		// 2) counts 에서 최대값과 그 index를 찾기
		max = 0;
		for(int i = 0; i < counts.length; i++) {
			int num = counts[i];
			if( max < num) {
				max = num;	// 가장 높은 등장빈도수 찾기
				answer = i;	// 최대값을 찾았을 때 그 위치(index)도 answer에 저장
			}
		}
//		System.out.println("max :" + max);
//		System.out.println("answer :" + answer);
		
		// 3) 최대값이 1개이면 answer에 그대로 담고, 최대값이 2개 이상이면 -1을 담는다
		int dup = 0;  // 중복체크를 위한 변수
		for(int i = 0; i < counts.length; i++) {  // counts에서
			if(counts[i] == max) {				  // 최대값이 총 몇 개인지 확인
				dup++;
			}
		}
		System.out.println("dup : " + dup);
		System.out.println("================");
		if(dup > 1) {						// 최대값이 1을 초과하면 (2개 이상이면)
			answer = -1;					// 최빈값이 유일하지 않으므로, -1을 대입하여 반환
		}
		return answer;
	}
}

public class Pro120812 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int answer1 = s.solution(new int[] {1,2,3,3,3,4});		
		int answer2 = s.solution(new int[] {1,1,2,2,});			
		int answer3 = s.solution(new int[] {1});				
	
		System.out.println(answer1); //3
		System.out.println(answer2);
		System.out.println(answer3);
	
	
	
	}

}
