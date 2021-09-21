package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Main_14891_톱니바퀴 {
	
	static String[] gears;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new String[4]; //톱니바퀴의 상태를 저장하는 String배열
		
		for (int i = 0; i < 4; i++) {
			gears[i] = br.readLine();
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1; //톱니바퀴의 인덱스 번호
			boolean clockwise = Integer.parseInt(st.nextToken())==1?true:false; //회전하는 방향 (true:시계방향, false:반시계방향)
		
			rotation(idx, clockwise, true, true);
		}
		
		int answer = gears[0].charAt(0)=='1'?1:0;
		answer += gears[1].charAt(0)=='1'?2:0;
		answer += gears[2].charAt(0)=='1'?4:0;
		answer += gears[3].charAt(0)=='1'?8:0;
		
		System.out.println(answer);
		br.close();
	}
	
	static void rotation(int idx, boolean clockwise, boolean left, boolean right) {

		//회전할 때 옆 바퀴와 맞닿는 부분은 2, 6인덱스(왼쪽은 2, 오른쪽은 6 확인하기)
		if (left && idx-1 >= 0) {
			if (gears[idx-1].charAt(2) != gears[idx].charAt(6)) {
				if (clockwise) { //현재 톱니가 시계방향이면 왼쪽은 반시계방향으로 회전.
					rotation(idx-1, false, true, false);
				} else {
					rotation(idx-1, true, true, false);
				}
			}
		}
		
		if (right && idx+1 < 4) {
			if (gears[idx].charAt(2) != gears[idx+1].charAt(6)) {
				if (clockwise) {
					rotation(idx+1, false, false, true);
				} else {
					rotation(idx+1, true, false, true);
				}
			}
		}
		
		if (clockwise) {
			gears[idx] = gears[idx].charAt(7) + gears[idx].substring(0, 7);
		} else {
			gears[idx] = gears[idx].substring(1, 8) + gears[idx].charAt(0);
		}
	}
	
}
