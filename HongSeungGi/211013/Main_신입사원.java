import java.util.*;
import java.io.*;

public class Main_신입사원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int answer = N;
			ArrayList<int[]> person = new ArrayList<>();
			int grade2 = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				person.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
				
			}
			Collections.sort(person, (a,b)->{
				return a[0]-b[0];
			});
			grade2 = person.get(0)[1]; 
			
			for(int i = 1; i < person.size(); i++) {
				if(person.get(i)[1] > grade2) {
					answer--;
				}
				else {
					grade2 = person.get(i)[1];
				}
			}
			System.out.println(answer);
		}
	}

}
