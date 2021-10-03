import java.util.*;
import java.io.*;

public class Main_왕위계승 {
	static double cal(String str, Map<String, String[]> m, String k) {
		if(str.equals(k)) return 1;
		if(!m.keySet().contains(str)) return 0;
		String[] p = m.get(str);
		double ans = (double)(cal(p[0],m,k)+cal(p[1],m,k))/2;
		return ans;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		Map<String, String[]> m = new HashMap<String, String[]>();
		
		String king = br.readLine();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String c = st.nextToken();
			String p1 = st.nextToken();
			String p2 = st.nextToken();
			
			m.put(c, new String[] {p1,p2});
		}
		String[] str = new String[M];
		for(int i = 0; i < M; i++) {
			str[i] = br.readLine();
		}
		String answer = "";
		double max = 0;
		for(int i = 0; i < M; i++) {
			double c = cal(str[i], m, king);
			if(max < c) {
				answer = str[i];
				max = c;
			}
		}
		System.out.println(answer);
	}

}
