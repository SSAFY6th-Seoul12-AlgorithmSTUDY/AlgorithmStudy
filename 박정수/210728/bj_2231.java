package study_01;

import java.util.Scanner;

public class bj_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); //N=입력 받은 수
		int result=0;
		
		for (int i = 0; i < N; i++) {  //1부터 N까지 모두 대입해보기
			int number=i;
			int sum=0; //각 자릿수 합 변수
			
			while(number!=0) {
				sum=sum+number%10;
				number=number/10;
			}
			
			//i값과 각 자릿수 누적합이 같을 경우(생성자를 찾았을 경우)
		if(i+sum==N) {
			result=i;
			break;
		}
		
		} System.out.println(result);
		sc.close();

	}

}
