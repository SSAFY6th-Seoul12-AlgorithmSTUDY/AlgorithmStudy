import java.io.*;
import java.util.*;

public class Main_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<int []> s = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < T; i++) {
			//s.push(Integer.parseInt(st.nextToken()));
			int top = Integer.parseInt(st.nextToken());
			if(s.size() == 0) {
				System.out.print(0+" ");
				s.push(new int[]{i+1,top});
			}
			else {
				while(true) {
					if(s.size() == 0) {
						System.out.print(0+" ");
						s.push(new int[]{i+1,top});
						break;
					}
					if(s.peek()[1] > top) {
						System.out.print(s.peek()[0]+" ");
						s.push(new int[]{i+1,top});
						break;
					}
					else {
						s.pop();
					}
				}
			}
		}
	}

}
