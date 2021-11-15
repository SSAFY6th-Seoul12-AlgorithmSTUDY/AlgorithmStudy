package com.ssafy.study_1020;

import java.io.*;
import java.util.*;

public class Main_bj_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무 수
		int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무 수

		int[] height = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {// 나무 높이 저장하기
			height[i] = Integer.parseInt(st.nextToken());
			
		}

		Arrays.sort(height); // 정렬

//		int low = height[0];
		int low = 0; //톱날 최소높이
		int high = height[N - 1]; //톱날 최대 높이


		while (low <= high) {
			int mid = (low + high) / 2; //중간값
			long cut = 0; //잘라낸 나무 길이들의 합

			for (int i = 0; i < N; i++) {
				if (mid < height[i]) { //중간값으로 나무들을 잘라가며(중간값보다 큰 경우에만)
					cut += height[i] - mid; //범위 좁히기
				}
			}

			if (cut >= M){ //잘라낸 나무 값이 M보다 클때
				low = mid +1; // 환경위해 딱 맞추려면 톱날 높이, 좀더 높아야
			}
			else if(cut < M){ //필요 나무보다 합이 작으니, 톱날 높이 더 낮추기
				high = mid -1;
			}

		}

		System.out.println(high); //low가 high를 넘어설때, high는 높이를 설정할 수 있는 높이에서 최대값

	}

}
//https://bellog.tistory.com/106