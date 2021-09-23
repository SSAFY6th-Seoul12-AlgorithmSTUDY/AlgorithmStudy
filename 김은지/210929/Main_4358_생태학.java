package baekjoon.string;

import java.io.*;
import java.util.*;

public class Main_4358_생태학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int cnt = 0;
		TreeMap<String, Integer> trees = new TreeMap<String, Integer>();
		
		while ((input = br.readLine()) != null) {
			cnt++;
			if (trees.containsKey(input)) {
				trees.put(input, trees.get(input)+1);
			} else {
				trees.put(input, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String s : trees.keySet()) {
			String rate = String.format("%.4f", trees.get(s)/(double)cnt*100);
			sb.append(s).append(" ").append(rate).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
