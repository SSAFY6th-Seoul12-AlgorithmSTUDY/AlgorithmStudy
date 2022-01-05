import java.util.*;
import java.io.*;
public class Main_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			Queue<int[]> pq = new LinkedList<int[]>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pq.offer(new int[] {j,Integer.parseInt(st.nextToken())});
			}
			int count = 1;
			while(!pq.isEmpty()) {
				int[] pop = pq.poll();
				boolean flag = false;
				for(int[] next : pq) {
					if(next[1] > pop[1]) {
						pq.offer(pop);
						flag = true;
						break;
					}
				}
				if(flag) continue;
				else {
					if(pop[0] == index) {
						System.out.println(count);
						break;
					}
					else {
						count++;
					}
				}
			}
		}
	}
}
