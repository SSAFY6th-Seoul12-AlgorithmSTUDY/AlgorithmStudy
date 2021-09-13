package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PRO_뉴스클러스터링 {
	static String str1 = "E=M*C^2";
	static String str2 = "e=m*c^2";
	static List<String> set1 = new LinkedList<>();
	static List<String> set2 = new LinkedList<>();
	static HashSet<String> union = new HashSet<>();
	static HashSet<String> hap = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		// 1. 두글자씩 자른다.
		for (int i = 0; i < str1.length() - 1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i + 1);
			if (a < 'A' || a > 'Z' || b < 'A' || b > 'Z') {
				continue;
			}
			set1.add("" + a + b);
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i + 1);
			if (a < 'A' || a > 'Z' || b < 'A' || b > 'Z') {
				continue;
			}
			set2.add("" + a + b);
		}
		Collections.sort(set1);
		Collections.sort(set2);
		// 둘다 공집합
		if(set1.size() == 0 && set2.size() == 0) {
			System.out.println(65536);
		}
		double a = 0, b = 0;
		label:while(!set1.isEmpty()) {
			for (int j = 0; j < set2.size(); j++) {
				// 교집합을 찾았을때
				if (set1.get(0).equals(set2.get(j))) {
					set1.remove(0);
					set2.remove(j);
					a++;
					b++;
					continue label;
				}
			}
			// 없을 경우 합집합 사이즈 +1
			set1.remove(0);
			b++;
		}
		b+=set2.size();
		System.out.println(a);
		System.out.println(b);
		System.out.println((int)(a/b*65536));
	}

}
