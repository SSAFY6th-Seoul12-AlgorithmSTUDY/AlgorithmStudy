import java.util.*;
import java.io.*;

public class Main_4358_생태학 {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> m = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double count = 0;
		String str = br.readLine();
		while(true) {
			count++;
			m.put(str, m.getOrDefault(str, 0)+1);
			str = br.readLine();
			if(str == null || str.length() == 0) break;
		}
		//System.out.println(count);
		List<String> keySet = new ArrayList<>(m.keySet());
		
		Collections.sort(keySet, (a,b)->{
			return a.compareTo(b);
		});
		for(String key : keySet) {
			System.out.println(key+" "+String.format("%.4f", (100*m.get(key))/count));
		}
	}

}
