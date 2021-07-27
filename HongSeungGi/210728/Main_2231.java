import java.util.Scanner;

public class Main_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int result = 0;
		for(int i = 0; i < T; i++) {
			int sum = 0;
			int num = i;
			while(true) {
				if(num == 0) {
					break;
				}
				sum += num%10;
				num /= 10;
			}
			if(i + sum == T) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
