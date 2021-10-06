package study_08;

import java.util.*;

public class Main_bj_s1_1254_팰린드롬만들기 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String S=sc.next();
		
		System.out.println(sol(S));
		sc.close();

	}

	private static int sol(String S) {
		int length=S.length();
		
		for (int i = 0; i < length; i++) {
			if(isPalind(S.substring(i))) { //ex)abab-> S.substring(1)=bab, substring-> 문자열 자르기
				return length+i; //length=4, 앞에 잘라서 버려진 문자만큼 뒤에 더하면 팰린드롬이 되기 때문에 문자 길이에 i를 더해준다
			}
		}
		return 0;
	}

	//팰린드롬인지 확인-> 앞에서 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열
	private static boolean isPalind(String S) { //abab라면
		int start=0;
		int end=S.length()-1;
		
		while(start<=end) {
			if(S.charAt(start) != S.charAt(end)) return false;
			start++;
			end--;
		}
		return true; // //true 리턴
	}

}
