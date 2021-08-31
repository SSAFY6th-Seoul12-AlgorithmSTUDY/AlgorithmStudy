import java.util.*;
import java.io.*;
public class Main_4386_별자리만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[N];
		double[][] star = new double[N][2];
		double[][] graph = new double[N][N];
		double[] distance = new double[N];
		Arrays.fill(distance, Double.MAX_VALUE);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			double[] point = star[i];
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				double d = Math.sqrt(Math.pow(Math.abs(point[0]-star[j][0]), 2) + 
						Math.pow(Math.abs(point[1]-star[j][1]), 2));
				graph[i][j] = d;
			}
		}
		/*for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}*/
		double result = 0;
		distance[0] = 0;
		for(int i = 0; i < N; i++) {
			double min = Double.MAX_VALUE;
			int mv = -1;
			
			for(int j = 0; j < N; j++) {
				if(!visit[j] && min > distance[j]) {
					min = distance[j];
					mv = j;
				}
			}
			result += min;
			//System.out.println(result);
			visit[mv] = true;
			for(int j = 0; j < N; j++) {
				if(!visit[j] && graph[mv][j] != 0 && distance[j] > graph[mv][j]) {
					distance[j] = graph[mv][j];
				}
			}
		}
		//System.out.println(Arrays.toString(distance));
		System.out.println(Math.round(result*100)/100.0);
	}

}
