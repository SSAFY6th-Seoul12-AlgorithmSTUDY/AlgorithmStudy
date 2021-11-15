package com.ssafy.study_1020;

import java.io.*;
import java.util.*;

public class Main_bj_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케
		
		for (int i = 1; i <= T; i++) {
			String p = br.readLine(); //수행할 함수
			
			int N = Integer.parseInt(br.readLine());
			String arr = br.readLine(); //배열
			
			Deque<Integer> deque = new LinkedList<>(); //앞, 뒤로 pop을 자유롭게 할 수 있음
			for (String s : arr.substring(1, arr.length() - 1).split(",")) 
				//substring(1, arr.length() - 1)으로 앞뒤 한개씩 []를 삭제해주고 ','를 기준으로 잘라줌
                if (!s.equals("")) //빈괄호는 ""이 반환되어 숫자로 형변환 할 수 없는 에러가 발생가능.
                    deque.add(Integer.valueOf(s));

            System.out.println(ac(deque, p));
		}
	}

	static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R')
                reverse = !reverse; // R이 들어오면 reverse를 이용하여 스위치로 활용
            else { //D로 삭제하는 함수일때
                if (deque.size() == 0) //덱이 비었으면 error 호출
                    return "error";

                if (reverse) //reverse가 T면 뒤집힌 경우니깐
                    deque.removeLast(); //Last로 뒤 요소 삭제하고(제일 뒤의 값이 첫번째 값이 되니깐)
                else //reverse가 F면 원 순서니깐
                    deque.removeFirst(); //맨앞의 값을 삭제
            }
        }

        StringBuilder sb = new StringBuilder("["); //출력 형태가  [ , , ] 형태이기에
        while (!deque.isEmpty()) {//덱이 비어있지 않다면
            sb.append(reverse ? deque.removeLast() : deque.removeFirst()); //reverse가 t면 뒤부터, f면 앞부터 출력해서 붙이기
            if (deque.size() != 0) //덱 사이즈가 0이 아니면(""만 있는 경우가 아니라면) ,로 값들 구분하기
                sb.append(',');
        }
        sb.append(']');

        return sb.toString(); //해당값 리턴.
    }
}
//https://girawhale.tistory.com/9