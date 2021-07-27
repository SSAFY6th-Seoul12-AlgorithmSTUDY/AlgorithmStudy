import java.util.Scanner;

public class Main_10448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] tri = new int[1001];
		int[] check = new int[1001];
		for(int i = 0; i < tri.length; i++) {
			tri[i] = ((i+1)*(i+2))/2;
		}
		//System.out.println(tri[0]);
		for(int i = 0; i < tri.length; i++) {
			for(int j = 0; j < tri.length; j++) {
				for(int x = 0; x < tri.length; x++) {
					int sum = tri[i]+tri[j]+tri[x];
					if(sum > 1000 || check[sum] == 1) {
						continue;
					}
					//System.out.println(sum);
					check[sum] = 1;
				}
			}
		}
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			if(check[num] == 1) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
