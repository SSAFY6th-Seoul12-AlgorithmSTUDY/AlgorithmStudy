import java.util.*;
import java.io.*;

public class Main_18352_특정거리의도시찾기 {
	public static class edge{
		int vertex;
		int w;
		public edge(int v, int w) {
			this.vertex = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<edge>[] edgeList = new ArrayList[N+1];
		int[] distance = new int[N+1];
	
		Arrays.fill(distance, Integer.MAX_VALUE);
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(edgeList[s] == null) {
				edgeList[s] = new ArrayList<>();
			}
			edgeList[s].add(new edge(e, 1));
		}
		distance[X] = 0;
		
		PriorityQueue<edge> q = new PriorityQueue<>((a,b)->{
			return a.w - b.w;
		});
		q.offer(new edge(X,0));
		while(!q.isEmpty()) {
			edge e = q.poll();
			int v = e.vertex;
			int w = e.w;
			if(distance[v] < w) continue;
			if(edgeList[v] == null) continue;
			for(int i = 0; i < edgeList[v].size(); i++) {
				int v2 = edgeList[v].get(i).vertex;
				int w2 = edgeList[v].get(i).w+w;
				if(distance[v2] > w2) {
					distance[v2] = w2;
					q.offer(new edge(v2, w2));
				}
			}
		}
		//System.out.println(Arrays.toString(distance));
		boolean flag = false;
		for(int i = 0; i < distance.length; i++) {
			if(K == distance[i]) {
				System.out.println(i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
	}

}
