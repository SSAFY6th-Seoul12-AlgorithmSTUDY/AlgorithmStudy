package com.ssafy.study_1006;

import java.util.Scanner;
import java.util.StringTokenizer;

// Pn -> IOI가 N개만큼 반복 P1 -> IOI, P2->IOIOI, P3 -> IOIOIOI
// 인덱스 비교 -> IOI 패턴을 만족하는지 확인하고, 연속된 횟수를 센 후 N과 일치하는경우 결과값+1
// 이후, 패턴회수 -1. => IOI가 연속된 긴 패턴이면 Pn이 연속으로 등장.
public class Main_bj_5525_IOIOI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //O의 개수,Pn을 의미
		int S = sc.nextInt(); //문자열 길이
		char[] str = new char[S];
		
		//StringTokenizer st = new StringTokenizer(sc.next());
		
		String st = sc.next();
		for (int i = 0; i < S; i++) { // 배열에 문자열 받기
			str[i] = st.charAt(i);
		}
		
		/*for (int i = 0; i < S; i++) {
			System.out.print(str[i]+" ");
		}*/
		
		int cnt = 0; // 최종 값
		int IOI = 0; //패턴 연속 횟수
		for (int i = 1; i < S-1; i++) {
			if(str[i-1] == 'I' && str[i] == 'O' && str[i+1] == 'I') {
				IOI++;
				System.out.print(IOI+" ");
				if(IOI == N) { //Pn만큼 이어졌으면 //P1 -> IOIOIOIOIOI -> /IOI/OIOIOIOI -> IO/IOI/OIOIOI
					IOI--; // 연속하는 긴 패턴이면 Pn이 연속으로 나타나니 -1
					cnt++; //최종값에 +1
					System.out.println(IOI);
				}
				i++; // N을 만족했으면, 다음 칸을 기준으로 확인
			}
			else IOI = 0; //패턴이 이어지지 않으면 연속 횟수 리셋
		}
		System.out.println(cnt);
	}
}
//https://mizzo-dev.tistory.com/entry/baekjoon5525