import java.util.*;
import java.io.*;
public class Main_9996_한국이그리울땐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		boolean flag = false;
		String first = "";
		String last = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '*') {
				flag = true;
				continue;
			}
			if(!flag) {
				first += str.charAt(i);
			}
			else {
				last += str.charAt(i);
			}
		}
		for(int i = 0; i < T; i++) {
			String alphabet = br.readLine();
			if(alphabet.length() < str.length()-1) {
				System.out.println("NE");
				continue;
			}
			String f = alphabet.substring(0,first.length());
			String l = alphabet.substring(alphabet.length()-last.length());
			
			if(f.equals(first) && l.equals(last)) {
				System.out.println("DA");
			}
			else {
				System.out.println("NE");
			}
		//	if(!check) System.out.println("DA");
		}
	}

}
