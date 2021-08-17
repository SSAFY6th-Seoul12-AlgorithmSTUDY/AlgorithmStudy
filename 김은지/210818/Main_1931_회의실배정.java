package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, (o1, o2)->(Integer.compare(o1[1], o2[1])==0?Integer.compare(o1[0], o2[0]):Integer.compare(o1[1], o2[1])));
		int time = meeting[0][1];
		int answer = 1;
		
		for (int i = 1; i < N; i++) {
			if (meeting[i][0] >= time) {
				time = meeting[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
