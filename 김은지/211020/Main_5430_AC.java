package baekjoon.deque;
import java.io.*;
import java.util.*;

public class Main_5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		label : for (int tc = 0; tc < T; tc++) {
			String calculation = br.readLine();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> num = new LinkedList<Integer>();
			String arr = br.readLine();
			arr = arr.substring(1, arr.length()-1);
			StringTokenizer st = new StringTokenizer(arr, ",");
			
			for (int i = 0; i < n; i++) {
				num.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean reverse = false;
			for (int i = 0; i < calculation.length(); i++) {
				int size = num.size();
				if (calculation.charAt(i) == 'R') {
					reverse = reverse?false:true;
				} else if (calculation.charAt(i) == 'D') {
					if (size == 0) {
						sb.append("error\n");
						continue label;
					}
					if (reverse) num.pollLast();
					else num.pollFirst();
				}
			}
			
			if (num.size() == 0) sb.append("[]\n");
			else {
				sb.append("[");
				while (!num.isEmpty()) {
					if (reverse) sb.append(num.pollLast()).append(",");
					else sb.append(num.pollFirst()).append(",");
				}
				sb.setLength(sb.length()-1);
				sb.append("]\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
}
