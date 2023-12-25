package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.print.attribute.HashAttributeSet;

public class Ex06 {
	public static void main(String[] args) {
		
		Random ran = new Random();
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() != 6) {	// set의 size가 6이면 반복을 종료한다
			int num = ran.nextInt(45) + 1;
			System.out.println("num : " + num);
			set.add(num);
		}

//=======================================================================================================				

		ArrayList<Integer> list = new ArrayList<>(set);	// 정렬에 사용
		list.sort(null);
		System.out.println("set : " + set);
		System.out.println("list : " + list);

//=======================================================================================================		
		
		
		
	}
}
