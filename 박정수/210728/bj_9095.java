package study_01;

import java.util.Scanner;

public class bj_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt(); //테스트 케이스 개수
		int a []= new int[11];
		
		for (int i = 1; i <= T; i++) {
			int N=sc.nextInt(); //입력한 정수 값
			System.out.println();
			
			a[1]=1;
			a[2]=2;
			a[3]=4;
			for (int j = 4; j <=10; j++) {
				a[j]=a[j-1]+a[j-2]+a[j-3];
			}
			System.out.print(a[N]);
		} sc.close();
		
		//왜 10은 적용 안되는지,,??
	}

}
