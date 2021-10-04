import java.util.*;
import java.io.*;


public class Main_컬러볼 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] ball = new int[N][3];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ball[i][0] = Integer.parseInt(st.nextToken());
			ball[i][1] = Integer.parseInt(st.nextToken());
			ball[i][2] = i;
		}
		
		Arrays.sort(ball, (a,b)->{
			return a[1]-b[1];
		});
		int[] answer = new int[N];

        int sum = 0;
        int[] color = new int[N+1];
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int[] a = ball[i];
            int[] b = ball[idx];

            while (b[1] < a[1]) {
                sum += b[1];
                color[b[0]] += b[1]; 
                idx++;
                b = ball[idx]; 
            }
            answer[a[2]] = sum - color[a[0]];
        }
		for(int s : answer) {
			System.out.println(s);
		}
	}

}
