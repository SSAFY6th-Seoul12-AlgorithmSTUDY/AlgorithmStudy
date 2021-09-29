import java.util.*;
import java.io.*;
public class Main_14891_톱니바퀴 {
	static void dfs(int num, int dir, int[] check, int[][] w) {
		check[num] = dir;
		
		int pre = num -1;
		int next = num +1;
		
		if(pre >= 0 && check[pre] == 0) {
			if(w[pre][2]!=w[num][6]) {
				dfs(pre, -1*dir, check, w);
			}
		}
		if(next <= 3 && check[next] == 0) {
			if(w[next][6] != w[num][2]) {
				dfs(next, -1*dir, check, w);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] w = new int[4][8];
		int[] check = new int[4];
		for(int i = 0; i < 4; i++) {
			String[] t = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                w[i][j] = Integer.parseInt(t[j]);
            }
		}
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            
            dfs(num,dir,check,w);
            for(int j = 0; j < 4; j++) {
            	if(check[j] != 0) {
            		int[] temp = new int[8];
            		
            		int idx;
            		for(int k = 0; k < 8; k++) {
            			idx = k + check[j];
            			if(idx == -1) {
            				idx = 7;
            			}
            			else if(idx == 8) {
            				idx = 0;
            			}
            			temp[idx] = w[j][k];
            		}
            		w[j] = temp;
            	}
            }
            check = new int[4];

		}
		int result = 0;
        for(int i = 0; i < 4; i++) {
        	int num = w[i][0];
        	if(num == 1) {
        		result += Math.pow(2, i);
        	}
        }
        
        System.out.println(result);
	}

}
