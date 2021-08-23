import java.util.*;
import java.io.*;

public class Main_9935_문자열폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		
		String str = br.readLine();
		String bomb = br.readLine();

		for(int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			if(s.size() >= bomb.length()) {
				boolean flag = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(s.get(s.size()-bomb.length()+j) != bomb.charAt(j)) {
						flag = false;
                        break;
					}
				}
				if(flag){
					for(int j = 0; j < bomb.length(); j++) {
						s.pop();
					}
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		for(Character c : s){
            ans.append(c);
        }
		System.out.println(ans.length() > 0 ? ans.toString() : "FRULA");
	}

}
