package com.ssafy.study_1013;

import java.util.Scanner;
//시간초과
public class Main_bj_1946_신입사원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 지원자 숫자
			int[][] arr = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt(); //서류 성적
				arr[i][1] = sc.nextInt(); // 면접 순위
			}
			
			int cnt = N;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {//i번째 지원자를, 전체 지원자와 비교
					if(arr[i][0] > arr[j][0]) { // 서류 성적이 더 낮은데
						if(arr[i][1] > arr[j][1]) { //면접 순위도 낮으면
							cnt -= 1; //뽑지 않으니 전체 지원자 수에서 -1
							break; //이미 작은 경우 발견했으니 다음 지원자로 넘어감
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
// https://seeminglyjs.tistory.com/200