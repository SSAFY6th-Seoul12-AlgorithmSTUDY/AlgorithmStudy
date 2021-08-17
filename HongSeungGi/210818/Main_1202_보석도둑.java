import java.util.*;
import java.io.*;

public class Main_1202_보석도둑 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
			return a[0]-b[0];
		});
		PriorityQueue<Integer> key = new PriorityQueue<>((a,b)->{
			return a-b;
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			q.offer(new int[] {m,v});
		}

		//int[] key = new int[K];
		for(int i = 0; i < K; i++) {
			int w = Integer.parseInt(br.readLine());
			key.offer(w);
		}
		
		long sum = 0;
		PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->{
			return b-a;
		});
		while(!key.isEmpty()){
			int k = key.poll();
			while(!q.isEmpty()) {
				if(q.peek()[0] <= k) max.offer(q.poll()[1]);
				else break;
			}
			if(!max.isEmpty()) sum += max.poll();
		}
		System.out.println(sum);
	}
}
