package 알고리즘스터디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRO_순위검색 {
	static String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
			"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
			"python backend senior chicken 50" };
	static String[] query = { "java and backend and junior and pizza 100",
			"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
			"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
	static String[][] tmp = { { "-", "cpp", "java", "python" }, { "-", "backend", "frontend" },
			{ "-", "junior", "senior" }, { "-", "chicken", "pizza" } };

	static HashMap<String, List<Integer>> hm = new HashMap<>();

	public static void main(String[] args) {
		int[] answer = new int[query.length];
		per(0, "");
		// 1. info를 토대로 hashmap 생성
		for (String s : info) {
			String[] temp = s.split(" ");
			make(0, "", Integer.parseInt(temp[4]), temp);
		}
		// 정렬
		for (Map.Entry<String, List<Integer>> entry : hm.entrySet()) {
			Collections.sort(entry.getValue());
		}

		int cnt = 0;
		// 2. query를 순회하며 해당 key값 조회
		for (String s : query) {
			String[] temp = s.split(" ");
			int score = Integer.parseInt(temp[7]);
			String st = "";
			for (int i = 0; i < temp.length - 1; i++) {
				if (temp[i].equals("and"))
					continue;
				st += temp[i];
			}

			List<Integer> output = hm.get(st);
			int idx = Collections.binarySearch(output, score);
			if (idx >= 0) {
				for (int a = idx - 1; a >= 0; a--) {
					if (output.get(idx) - output.get(a) > 0)
						break;
					else
						idx = a;
				}
				answer[cnt] = output.size() - idx;
			} else {
				answer[cnt] = output.size() + idx + 1;
			}

			cnt++;
		}
		System.out.println(Arrays.toString(answer));
	}

	static void make(int depth, String str, int score, String[] temp) {
		if (depth == 4) {
			// 만약 key가 존재하면 add
			if (hm.containsKey(str)) {
				hm.get(str).add(score);
			}
			// key가 없다면 ArrayList를 새로 만든후 요소 추가
			else {
				hm.put(str, new ArrayList<>());
				hm.get(str).add(score);
			}
			return;
		}
		make(depth + 1, str + "-", score, temp);
		make(depth + 1, str + temp[depth], score, temp);
	}

	static void per(int depth, String str) {
		if (depth == 4) {
			hm.put(str, new ArrayList<>());
			return;
		}
		for (int i = 0; i < tmp[depth].length; i++) {
			per(depth + 1, str + tmp[depth][i]);
		}
	}
}
