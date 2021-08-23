import java.util.*;
import java.io.*;

public class Main_1182_부분수열의합 {
	static int count;
	public static void cal(int idx, int[] arr, int sum, int answer) {
		//System.out.println(answer+" idx :"+idx);
		if(idx == arr.length) {
			if(sum == answer) count++;
			return;
		}
		cal(idx+1, arr, sum, answer + arr[idx]);
		cal(idx+1, arr, sum, answer);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int S  = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visit = new boolean[N];
		cal(0, arr, S, 0);
		System.out.println(count = S == 0 ? count-1 : count);
	}

}
