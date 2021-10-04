import java.io.*;

public class Main_펠린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for(int i = 0; i <= s.length(); i++) {
			String p = s;
			boolean flag = false;
			if(i != 0) {
				for(int j = i-1; j >= 0; j--) {
					p += s.charAt(j);
				}
			}
			
			for(int j = 0; j < p.length()/2; j++) {
				if(p.charAt(j) != p.charAt(p.length()-j-1)) flag = true;
			}
			if(flag) continue;
			else {
				System.out.println(p.length());
				break;
			}
		}
	}

}
