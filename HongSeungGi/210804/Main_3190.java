import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> snake = new LinkedList<int[]>();
		Map<Integer, String> dir = new HashMap<Integer, String>();
		StringTokenizer st;
		int index = 0;
		int[] dx = {0, 1, 0, -1}; //세로
		int[] dy = {1, 0, -1, 0}; //가로
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		int apple = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x-1][y-1] = 1;
		}
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			dir.put(time, d);
		}
		
		snake.add(new int[] {0,0});
		int startx = 0;
		int starty = 0;
		int time = 0;
		boolean flag = false;
		while(true) {
			time++;
			startx += dx[index];
			starty += dy[index];
			
			// 검사
			if(startx < 0 || starty < 0 || startx > N-1 || starty > N-1) {
				flag = true;
			}
			for(int[] s : snake) {
				if(startx == s[0] && starty == s[1]) {
					flag = true;
				}
			}
			if(flag) {
				break;
			}
			if(board[startx][starty] == 1) {
				board[startx][starty] = 0;
				snake.add(new int[] {startx,starty});
			}
			else {
				snake.add(new int[] {startx,starty});
				snake.poll();
			}
			if(dir.containsKey(time)) {
				if(dir.get(time).equals("D")) {
					index++;
					if(index == 4) {
						index = 0;
					}
				}
				else {
					index--;
					if(index == -1) {
						index = 3;
					}
				}
			}
		}
		System.out.println(time);
	}
}
