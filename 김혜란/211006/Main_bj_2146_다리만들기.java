package com.ssafy.study_1006;

import java.io.*;
import java.util.*;

public class Main_bj_2146_다리만들기 {

	static int n, map[][], island[][];
    static boolean visit[][];
    static Stack<Point> start;
    static int dx[] = {-1,1,0,0}; //이동
    static int dy[] = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE; //가장 짧은 다리
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine()); //입력받은 맵의 크기
        map = new int[n][n]; //입력받은 맵
        island = new int[n][n]; //같은 섬끼리 묶은 배열
        visit = new boolean[n][n]; //섬끼리 묶을 때 방문처리
        start = new Stack<>(); //모든 섬의 모든 좌표
        
        for(int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                if(map[i][j] == 1) //섬이면
                    start.push(new Point(i, j, 0)); //포인터에 x,y 표랑 다리 길이 0 저장 -> start 스택에 저장.
            }
        }
        
        int number = 1;//섬에 번호 붙일 변수
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visit[i][j]) { //섬이고, 방문안했으면
                    island[i][j] = number; //섬번호 넣어주고
                    visit[i][j] = true; //방문처리하고
                    tie(i, j, number); // dfs 돌리기(같은 섬으로 묶기)
                    number++; //다음 섬은 다음 번호
                }
            }
        }
        
        while(!start.isEmpty()) {
            Point now = start.pop(); // 스택에 있는 좌표를 하나씩 꺼내서
            bridge(now.x, now.y); //다리 만들기
        }
        System.out.println(answer-1); // 마지막에 다른 섬에 도착한것도 포함되어 있으니 -1
    }
    
    public static void tie(int x, int y, int number) { //같은 섬 묶기
    	//방문좌표에서 상하좌우 이동하면 1이면 같은 섬이니깐 같은 number로 묶기.
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(check(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                island[nx][ny] = number; //island에 섬의 번호 저장
                visit[nx][ny] = true;
                tie(nx, ny, number); //재귀
            }
        }
    }
    
    public static void bridge(int x, int y) { //bfs
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0)); //스택에 있던 좌표 기준으로 다리 세우기
        int number = island[x][y]; //섬 번호
        visit = new boolean[n][n];
        visit[x][y] = true; //방문처리
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.count >= answer) // ???다리 길이가 기존 값보다 길면 리턴?
                return;
            if(island[now.x][now.y] != 0 && island[now.x][now.y] != number) { //바다 아니고, 기존섬과 다른 섬이면
                answer = Math.min(answer, now.count);  //다른 섬에 도착 -> answer, 최솟값으로 갱신
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i]; 
                int ny = now.y + dy[i];
                
              //상하좌우 돌면서, 현재 섬과 다른 번호 섬 만날때까지 진행
                if(check(nx, ny) && !visit[nx][ny] && island[nx][ny] != number) {
                    visit[nx][ny] = true;
                    q.offer(new Point(nx, ny, now.count + 1));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) { //현재 좌표가 유효한지 범위 체크
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Point{ //x, y 좌표와 다리의 길이 count를 저장
        int x, y, count;
        
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
//https://jellyinghead.tistory.com/63