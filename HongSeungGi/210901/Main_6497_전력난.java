import java.util.*;
import java.io.*;

public class Main_6497_전력난 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<int []>[] graph = new ArrayList[m];
			boolean[] visit = new boolean[m];
			int[] distance = new int[m];
			Arrays.fill(distance, Integer.MAX_VALUE);
			if(m == 0 && n == 0) {
				break;
			}
			int count = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				count += cost;
				if(graph[start] == null) {
					graph[start] = new ArrayList<>();
				}
				if(graph[end] == null) {
					graph[end] = new ArrayList<>();
				}
				graph[start].add(new int[] {end, cost});
				graph[end].add(new int[] {start, cost});
			}
			
			int result = 0;
			distance[0] = 0;
			for(int i = 0; i < m; i++) {
				int min = Integer.MAX_VALUE;
				int mv = -1;
				
				for(int j = 0; j < m; j++) {
					if(!visit[j] && min > distance[j]) {
						min = distance[j];
						mv = j;
					}
				}
				visit[mv] = true;
				result += min;
				for(int[] a : graph[mv]) {
					if(!visit[a[0]] && distance[a[0]] > a[1]) {
						distance[a[0]] = a[1];
					}
				}
			}
			//System.out.println(Arrays.toString(distance));
			System.out.println(count-result);
		}
	}

}
