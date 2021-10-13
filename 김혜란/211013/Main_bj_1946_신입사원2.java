package com.ssafy.study_1013;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//왜 시간초과??
public class Main_bj_1946_신입사원2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(); // 지원자 숫자
			int[][] arr = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt(); //서류 성적
				arr[i][1] = sc.nextInt(); // 면접 순위
			}
			
			int cnt = 1; //정렬 1번은 자동 채용. 이미 하나는 모두보다 높은점수니깐.
			
			//정렬
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) { //서류 기준 오름차순
					return Integer.compare(arr1[0], arr2[0]);
				}
			});
			
			int num1 = arr[0][1]; //첫번째 지원자의 면접 성적이 기준. 이보다 높으면 채용, 낮으면 이미 서류도 낮아서 탈락
			
			for (int i = 1; i < N; i++) {
				if (arr[i][1] < num1) { // 면접 성적이 그 전에 선발된 이보다 좋다면 뽑힘
					cnt++; //합격자 1명 추가
					num1 = arr[i][1]; // 다음 합격자는 서류는 이미 낮으니, 면접이 i번째보다 좋아아햠.
				} else {

				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
// https://seeminglyjs.tistory.com/200
// https://zzang9ha.tistory.com/51