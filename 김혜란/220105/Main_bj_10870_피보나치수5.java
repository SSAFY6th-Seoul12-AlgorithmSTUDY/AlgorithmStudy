package com.ssafy.study_0105;

import java.util.*;

public class Main_bj_10870_피보나치수5 {
	
//	static int hap;
//	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //0-n까지의 수
		
//		System.out.println(sum(2, 0)); 
		System.out.println(sum(N)); 
	}
	
	static int sum(int n) {
		if(n <= 1) return n;
		//Fn = Fn-1 + Fn-2
		return sum(n-1)+sum(n-2);
	}
}
//https://cocoon1787.tistory.com/10
//https://st-lab.tistory.com/94










//이 방법은 왜??
//static int sum(int i, int hap) {
//	if(i == N) return hap;
//	//Fn = Fn-1 + Fn-2
//	hap = i-1 + i+2;
////	System.out.println(hap);
//	return sum(i+1, hap);
//}