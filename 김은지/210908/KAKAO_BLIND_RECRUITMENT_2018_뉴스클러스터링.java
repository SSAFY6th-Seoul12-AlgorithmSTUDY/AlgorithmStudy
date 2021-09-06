package programmers.kakao;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_뉴스클러스터링 {
	
	static int union = 0;

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french")); //16384
		System.out.println(solution("handshake", "shake hands")); //65536
		System.out.println(solution("aa1+aa2", "AAAA12")); //43690
		System.out.println(solution("E=M*C^2", "e=m*c^2")); //65536
		System.out.println(solution("aaaa+bbb", "aaa+bbbb")); //43690
	}

	public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        
        makeSubSet(map1, str1);
        makeSubSet(map2, str2);
        if (map1.size() == 0 && map2.size() == 0) return 65536;
        
        int intersection = 0;
        for (String s : map1.keySet()) {
			if (map2.containsKey(s)) {
				int minCnt = Math.min(map1.get(s), map2.get(s));
				intersection += minCnt;
				union -= minCnt;
			} 
		}
        
        return (int)((intersection/(double)union)*65536);
    }
	
	static void makeSubSet(Map<String, Integer> map, String str) {
		String s = str.toLowerCase();
		for (int i = 0; i < str.length()-1; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i+1);
//			if (!isAlpha(c1) || !isAlpha(c2)) continue;
			if (!Character.isLetter(c1) || !Character.isLetter(c2)) continue;
			String sub = c1+""+c2;
			if (map.containsKey(sub)) {
				map.put(sub, map.get(sub)+1);
			} else {
				map.put(sub, 1);
			}
			union++;
		}
	}
	
//	static boolean isAlpha(char c) {
//		if (97 <= c && c <= 122) return true;
//		return false;
//	}

}
