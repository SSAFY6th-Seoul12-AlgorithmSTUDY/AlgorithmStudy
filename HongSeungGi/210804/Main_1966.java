
import java.io.*;
import java.util.*;


public class Main_1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    //int[] arr = {1,1,9,1,1,1};
	    
	 
	    //System.out.println(q);
	    for(int i = 0; i < T; i++) {
	    	int count = 0;
	    	int key = 0;
	    	int size = 0;
	    	Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	size = Integer.parseInt(st.nextToken());
	    	key = Integer.parseInt(st.nextToken());
	    	st = new StringTokenizer(br.readLine());
	    	for(int j = 0; j < size; j++) {
	    		map.put(j, Integer.parseInt(st.nextToken()));
	    	}
	    	for(Map.Entry<Integer, Integer> m : map.entrySet()) {
	    		q.offer(m);
	    	}
	    	while(!q.isEmpty()) {
	    		Map.Entry<Integer, Integer> first = q.poll();
	    		boolean check = false;
	    		for(Map.Entry<Integer, Integer> e: q) {
	    			if(e.getValue() > first.getValue()) {
	    				check = true;
	    				break;
	    			}
	    		}
	    		if(check) {
	    			q.offer(first);
	    			continue;
	    		}
	    		count++;
	    		if(first.getKey() == key) {
	    			break;
	    		}
	    	}
	    	System.out.println(count);

	    }
	}

}
