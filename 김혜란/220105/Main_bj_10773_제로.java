package com.ssafy.study_0105;

import java.util.*;

public class Main_bj_10773_제로 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); //정수 k -> 점수 개수
		Stack<Integer> score = new Stack<Integer>();
		
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt(); //값 입력받기
			
			if(num == 0) { //이번에 들어온 값이 0이면 이전 값 빼기
				score.pop();
			}
			else {//이번에 들어온 값이 0이 아니면 스택에 넣어주기
				score.push(num);
			}
		}
		
		int sum = 0; //합계 구할 변수
		int size = score.size(); //점수가 들어있는 스택 사이즈
		
		for (int i = 0; i < size; i++) { //스택에서 하나씩 뺴면서 더해주기.
			sum += score.pop();
		}
		
		System.out.println(sum);
	}
}
//https://www.acmicpc.net/problem/10773
//https://st-lab.tistory.com/177
//https://steady-coding.tistory.com/42