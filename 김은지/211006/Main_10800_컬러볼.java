package baekjoon.prefixsum;

import java.io.*;
import java.util.*;

public class Main_10800_컬러볼 {
	
	//공 크기, 해당 번호 공 중에서 현재 공 크기 이하의 공 크기의 합을 저장
	static class Ball {
		int size, total;

		public Ball(int size, int total) {
			this.size = size;
			this.total = total;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		//공 번호를 인덱스로 갖는 list배열
		LinkedList<Ball>[] balls = new LinkedList[N];
		int[][] input = new int[N][2];
		int[][] temp = new int[N][2];
		
		//번호, 크기에 맞는 답을 저장할 이중 map
		Map<Integer, Map<Integer, Integer>> answer = new HashMap<Integer, Map<Integer,Integer>>();
		//크기에 따라 먹을 수 있는 합(key:크기, value:더 작은 공 크기의 합) - 번호 고려 X
		Map<Integer, Integer> sum = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < N; i++) {
			balls[i] = new LinkedList<Ball>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken())-1;
			int S = Integer.parseInt(st.nextToken());
			input[i][0] = C;
			input[i][1] = S;
			//인덱스 유지할 temp배열
			temp[i][0] = C;
			temp[i][1] = S;
		}
		
		//공의 크기 순으로 정렬
		Arrays.sort(input, (o1, o2)->Integer.compare(o1[1], o2[1]));

		sum.put(input[0][1], 0);
		int s = input[0][1];
		for (int i = 1; i < N; i++) {
			if (input[i][1] != input[i-1][1]) {
				sum.put(input[i][1], s);
			} 
			s += input[i][1];
		}
		
		balls[input[0][0]].add(new Ball(input[0][1], input[0][1]));
		answer.put(input[0][0], new HashMap<>());
		answer.get(input[0][0]).put(input[0][1], 0);
		for (int i = 1; i < N; i++) {
			int C = input[i][0];
			int S = input[i][1];
			int total = 0;
			
			if (!balls[C].isEmpty()) { //현재 번호의 첫번째 공이 아니라면 이전 공 total을 받아옴
				total = balls[C].getLast().total;
			} 
			balls[C].add(new Ball(S, total + S)); //이전 공의 total에 현재 공 크기를 더한 값을 total로 저장
			
			//같은 번호, 같은 크기의 공이면 continue
			if (answer.containsKey(C) && answer.get(C).containsKey(S)) {
				continue;
			}
			
			//answer에 추가(현재 공 크기가 먹을 수 있는 값에서 같은 번호의 합을 빼줘야 함)
			if (!answer.containsKey(C)) answer.put(C, new HashMap<>());
			answer.get(C).put(S, sum.get(S) - total);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(answer.get(temp[i][0]).get(temp[i][1])).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
