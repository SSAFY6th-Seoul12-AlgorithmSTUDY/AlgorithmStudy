import java.util.*;
import java.io.*;


public class Main1 {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, ArrayList<Integer>> col = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			String h = "";
			ArrayList<String> arr = new ArrayList<>();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == '-') {
					h += line.charAt(j);
					continue;
				}
				else {
					if(col.containsKey(j)) {
						col.get(j).add(i);
					}
					else {
						ArrayList<Integer> a = new ArrayList<>();
						a.add(i);
						col.put(j, a);
					}
					if(!h.equals("")) {
						arr.add(h);
						h = "";
					}
				}
			}
			if(!h.equals("")) {
				arr.add(h);
			}
			count += arr.size();
		}
		//System.out.println(count);
		for(int key: col.keySet()) {
			ArrayList<Integer> a = col.get(key);
			for(int i = 0; i < a.size(); i++) {
				if(i+1 > a.size()-1) {
					count++;
					break;
				}
				if(a.get(i)+1 == a.get(i+1)) {
					continue;
				}
				else {
					count += 1;
				}
			}
		}
		System.out.println(count);
	}

}
