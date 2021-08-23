import java.util.*;
import java.io.*;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str,"-");
		String[] num = new String[st.countTokens()];
		
		int idx = 0;
		while(st.hasMoreTokens()) {
			num[idx] = st.nextToken();
			idx++;
		}
		for(int i = 0; i < num.length; i++) {
			if(num[i].contains("+")) {
				st = new StringTokenizer(num[i], "+");
				int sum = 0;
				while(st.hasMoreTokens()) {
					sum += Integer.parseInt(st.nextToken());
				}
				num[i] = Integer.toString(sum);
			}
		}
		int result = Integer.parseInt(num[0]);
		for(int i = 1; i < num.length; i++) {
			result -= Integer.parseInt(num[i]);
		}
		System.out.println(result);
	}
}
