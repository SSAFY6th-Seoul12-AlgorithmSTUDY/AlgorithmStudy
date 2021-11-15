package study_09;

import java.util.*;

public class Main_bj_s1_1946_신입사원 {
	static int N;
	static int[][] num;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
		N=sc.nextInt();
		num= new int[N][2]; //지원자 서류, 면접 점수 담을 배열
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				num[i][j]=sc.nextInt();
			}
		}
		
		int cnt=N; //처음에는 지원자 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(num[i][0]>num[j][0]) {
					if(num[i][1]>num[j][1]) {
						cnt=cnt-1;
					break;
					}
				}
			}
		}
		System.out.println(cnt);

	}sc.close();

}
}
