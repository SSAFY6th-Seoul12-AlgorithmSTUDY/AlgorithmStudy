import java.util.*;
import java.io.*;


public class Main_1931_회의실배정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int []> q = new PriorityQueue<int[]>();
		int T = Integer.parseInt(br.readLine());
		int[][] time = new int[T][2];
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i][0] = start;
			time[i][1] = end;
		}
		Arrays.sort(time, (a,b)->{
			if(a[1] == b[1]) return a[0]-b[0];
			return a[1]-b[1];
		});
		int count = 0;
		int endTime = 0;
		for(int i = 0; i < T; i++) {
			if(endTime <= time[i][0]) {
				count++;
				endTime = time[i][1];
			}
		}
		
		System.out.println(count);
	}

}
