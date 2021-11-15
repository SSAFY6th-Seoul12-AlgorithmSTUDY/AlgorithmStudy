package com.ssafy.study_1020;

import java.io.*;
import java.util.*;

public class Main_bj_1068_트리 {
	
	static int N, dele;
	static int[] parent;
	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(br.readLine());
//		N = sc.nextInt();
		parent = new int[N];
		int root = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
//			parent[i] = sc.nextInt();
			parent[i] = Integer.parseInt(st.nextToken()); //각 노드들의 부모노드 값 저장
			if(parent[i] == -1) root=i; //값이 -1이면 루트 노드
		}
		dele = Integer.parseInt(br.readLine()); //삭제할 노드의 번호
//		dele =sc.nextInt();
		
		deleNode(dele); //삭제할 노드의 번호로 삭제 시작
		
		cnt = 0; //리프노드 갯수 저장할 변수
		visited = new boolean[N]; //방문처리용
		cntLeaf(root);
		
		System.out.println(cnt);
	}

	private static void deleNode(int d) {
		parent[d] = -2; //삭제된 노드 -2로 표시
		for (int i = 0; i < N; i++) {
			if(parent[i] == d) deleNode(i);  //부모가 d번 노드라면 재귀로 삭제.
		}
	}
	
	private static void cntLeaf(int s) { //리프노드 계산 -> 루트노드에서 시작, 자식노드를 dfs로 탐색
		boolean isleaf = true;
		visited[s] = true; //해당위치 방문처리
		if(parent[s] != -2) { //루트노드가 아닐때
			for (int i = 0; i < N; i++) {
				if(parent[i] == s && visited[i] == false) { //부모가 s번이면서 아직 방문 안한 노드
					cntLeaf(i); //다시 탐색
					isleaf = false;
				}
			}
			if(isleaf) cnt++; //자식이 없으면 리프노트니깐 갯수 추가.
		}
	}
}
//https://moonsbeen.tistory.com/229