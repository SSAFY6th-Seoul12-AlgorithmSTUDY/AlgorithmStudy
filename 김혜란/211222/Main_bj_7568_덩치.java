package com.ssafy.study_1222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_bj_7568_덩치 {

	public static void main(String[] arg) throws NumberFormatException, IOException {	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //사람 수
		int[][] size = new int[N][2]; //키, 무게
		int[] cnt = new int[N]; //자기보다 큰 사람 카운팅할 배열
		
		for (int i = 0; i < N; i++) {
			cnt[i] = 1; //등수는, 자기보다 큰 사람 + 1이니깐 기본으로 모두 1의값 주기
			size[i][0] = sc.nextInt();
			size[i][1] = sc.nextInt();			
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue; //같은 번호면 같은 사람 -> 스킵
				if(size[i][0] < size[j][0] && size[i][1] < size[j][1]) { //키, 무게 모두 i보다 커야 덩치 큰거
					cnt[i]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(cnt[i]+" ");
		}
		
	}
	
}
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int N = Integer.parseInt(br.readLine());
//int[][] size = new int[N][2];
//
//StringTokenizer st = null;
//for (int i = 0; i < N; i++) {
//	int str = Integer.parseInt(br.readLine());
//	size[i][1] = st.nextToken(str);
//}