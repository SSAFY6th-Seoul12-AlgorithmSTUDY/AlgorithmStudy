import java.io.*;

import java.util.*;


public class Main_9375 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int answer = 1;
			for(int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				String value = st.nextToken();
				String key = st.nextToken();
				if(map.containsKey(key)) {
					map.get(key).add(value);
					continue;
				}
				ArrayList<String> list = new ArrayList<>();
				list.add(value);
				map.put(key, list);
			}
			for(String k : map.keySet()) {
				answer *= map.get(k).size()+1;
			}
			System.out.println(answer-1);
		}
	}

}
