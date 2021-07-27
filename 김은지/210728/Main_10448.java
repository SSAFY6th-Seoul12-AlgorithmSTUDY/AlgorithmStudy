package baekjoon;

import java.util.Scanner;

public class Main_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] t = new int[43];
        t[0] = 1;
        for (int i = 1; i < t.length; i++) {
			t[i] += t[i-1] + i+1;
		}
        
        for (int i = 0; i < sc.nextInt(); i++) {
			int num = sc.nextInt();
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < t.length; k++) {
					
				}
			}
		}
        
        sc.close();
        
    }
}
