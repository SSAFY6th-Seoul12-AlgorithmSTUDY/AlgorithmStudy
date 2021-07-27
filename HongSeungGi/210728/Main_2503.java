import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> result = new ArrayList<>();
	
	public static void calculation(int[] number, int strike, int ball) {
		
		List<Integer> box = new ArrayList<>();
		
		for(int i = 123; i < 988; i++) {
			int cstrike = 0;
			int cball = 0;
			int f = i/100;
			int s = (i%100)/10;
			int t = (i%100)%10;
			
			if(f==s||s==t||t==f||f==0||s==0||t==0) {
				continue;
			}
			int[] arr = {f,s,t};
			
			for(int j = 0; j < arr.length; j++) {
				for(int k = 0; k < arr.length; k++) {
					if(arr[j] == number[k]) {
						if(j == k) {
							cstrike++;
						}
						else {
							cball++;
						}
					}
				}
			}
			if(cstrike == strike && cball == ball) {
				box.add(i);
			}
		}
		if(result.isEmpty()) {
			for(int i : box) {
				result.add(i);
			}
		}
		else {
			for(int i = 0; i < result.size(); i++) {
				if(box.contains(result.get(i))) {
					continue;
				}
				result.remove(i);
				i--;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		int strike = 0;
		int ball = 0;
		int[] number = new int[3];
		for(int i = 0; i < T; i++) {
			String[] str = sc.nextLine().split(" ");
			//System.out.println(Arrays.deepToString(str));
			number[0] = Character.getNumericValue(str[0].charAt(0));
			number[1] = Character.getNumericValue(str[0].charAt(1));
			number[2] = Character.getNumericValue(str[0].charAt(2));
			strike = Integer.parseInt(str[1]);
			ball = Integer.parseInt(str[2]);
			calculation(number, strike, ball);
		}
		System.out.println(result.size());
		sc.close();
	}
}