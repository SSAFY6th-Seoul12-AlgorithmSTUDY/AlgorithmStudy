package com.ssafy.study_1006;

import java.util.Scanner;

public class Main_bj_1254_팰린드롬만들기 {
//0부터 주어진 문자열 길이까지 문자를 잘라서 팰린드롬인지 판별한다.
//1) 자른 문자가 팰린드롬이 맞는 경우 
	//앞에 잘라서 버려진 문자만큼 뒤에 더하면 팰린드롬이 되기 때문에 문자 길이에 i를 더해준다.
//2) 팰린드롬을 만족하는 경우가 없으면 
	//주어진 문자를 그대로 더하면 길지만 팰린드롬을 만족하기 때문에 문자 길이*2를 해준다. 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(calculate(input));
	}
	
	 private static int calculate(String input) {

	        int len = input.length();

	        for (int i=0; i<len; i++) {
	            if (isPalin(input.substring(i))) { //substring으로 문자열 자르기
	                return len+i;
	            }
	        }

	        return len*2;
	    }//calculate

	    private static boolean isPalin(String input) {
	        int start = 0;
	    	int end = input.length()-1;

	    	//start 하나씩 증가시키면서 팰린드롬 성립되는지 확인
	        while (start <= end) {
	            if (input.charAt(start) != input.charAt(end)) {
	                return false; 
	            }
	            //팰린드롬 아니면 start 하나더 증가시키고 다시 체크
	            start++;
	            end--;;
	        }

	        return true; //성립하면 즉시 종료
	    }//isPalin

}
//https://hidelookit.tistory.com/182
//https://namhandong.tistory.com/213