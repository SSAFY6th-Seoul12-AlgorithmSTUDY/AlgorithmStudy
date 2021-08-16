import java.util.*;
import java.io.*;


public class Main_1343_폴리오미노 {
	static String one = "AAAA";
	static String two = "BB";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String change = br.readLine();
		int count = 0;
		String str = "";
		for(int i = 0; i < change.length(); i++) {
			count++;
			if(change.charAt(i) == '.') {
				count = 0;
				str += ".";
				continue;
			}
			if(count == 4) {
				str += one;
				count = 0;
				continue;
			}
			else if(count == 2) {
				if(i+1 < change.length() && change.charAt(i+1)=='X') continue;
				str += two;
			}
		}
		//System.out.println(str);
		if(str.length() != change.length()){
			System.out.println(-1);
		}
		else {
			System.out.println(str);
		}
	}
}
