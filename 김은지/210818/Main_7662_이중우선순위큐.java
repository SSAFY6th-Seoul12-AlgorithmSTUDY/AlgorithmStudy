package baekjoon.priorityque;

import java.io.*;
import java.util.*;

public class Main_7662_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				if (c == 'I') {
					if (map.containsKey(n)) map.put(n, map.get(n)+1);
					else map.put(n, 1);
				} else {
					if (map.size() == 0) continue;
					int key;
					if (n == -1) {
						key = map.firstKey();
					} else {
						key = map.lastKey();
					}
					if (map.get(key) == 1) {
						map.remove(key);
					} else {
						map.put(key, map.get(key)-1);
					}
				}
			}
			if (map.size() == 0) sb.append("EMPTY");
			else sb.append(map.lastKey()).append(" ").append(map.firstKey());
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
