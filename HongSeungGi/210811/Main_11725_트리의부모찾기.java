import java.util.*;
import java.io.*;

public class Main_11725_트리의부모찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
		int[] p = new int[N+1];
		boolean visit[] = new boolean[N + 1];
		for(int i = 0; i < N; i++) {
			if(i+1 == 1) {
				p[i+1] = 0;
				continue;
			}
			p[i+1] = i+1;
		}
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(m.containsKey(f) || m.containsKey(e)) {
				if(m.containsKey(f)) {
					m.get(f).add(e);
					if(m.containsKey(e)) {
						m.get(e).add(f);
					}
					else {
						ArrayList<Integer> a = new ArrayList<>();
						a.add(f);
						m.put(e, a);
					}
				}
				else {
					m.get(e).add(f);
					if(m.containsKey(f)) {
						m.get(f).add(e);
					}
					else {
						ArrayList<Integer> a = new ArrayList<>();
						a.add(e);
						m.put(f, a);
					}
				}
			}
			else {
				ArrayList<Integer> a = new ArrayList<>();
				a.add(f);
				m.put(e, a);
				a = new ArrayList<>();
				a.add(e);
				m.put(f, a);
			}
		}

		Stack<Integer> stack = new Stack<>();

        stack.push(1);
        visit[1] = true;

        while(!stack.isEmpty()){
            int start = stack.pop();

            for(int i = 0 ; i < m.get(start).size(); i++){
            	//System.out.println(m.get(start)+" asdf");
                int end = m.get(start).get(i);

                if(visit[end] == false) {
                    p[end] = start;
                    stack.push(end);
                    visit[end] = true;
                }
            }
            //System.out.println(Arrays.toString(p));
        }
		for(int i = 2; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}
}
