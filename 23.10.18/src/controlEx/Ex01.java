package controlEx;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input;
    int num1;
    int num2;
    
    System.out.println("주민등록번호 13자리 (xxxxxx-yyyyyyy)");
    System.out.print("입력 : \n");
    input = "930516-2345678" ;
    
    num1 = Integer.parseInt(input.split("-")[0]);
    num2 = Integer.parseInt(input.split("-")[1]);
    System.out.println("num1 :" + num1);
    System.out.println("num2 :" + num2);
    System.out.println();
    
    // 4자리의 출생연도, 2자리의 출생월, 2자리의 출생일
    // 그리고 성별은 문자열로 준비하여 모두 출력하세요
    
    int year, month, date, genderA;
    String gender;
    
    year = num1 / 10000;
    month = num1 / 100 % 100;
    date = num1 % 100;
    
    genderA = num2 / 1000000 ;
    
    switch(genderA) {
    case 1: case 2:
    	year += 1900;
    	break;
    case 3: case 4:
    	year += 2000;
    	break;
    }
    
    switch(genderA) {
    case 1: case 3: 
    	gender = "남성";
    	break;
    case 2: case 4:
    	gender = "여성";
    default:
    	gender = "";
    	break;
    }
    
	System.out.printf("%4d - %02d - %02d (%s)\n ", year,month,date,gender);
	
	sc.close();
	
	}
}
