package 알고리즘스터디;

public class PRO_타겟넘버 {
	static int[] numbers = { 1, 1, 1, 1, 1 };
	static int target = 3;
	static int answer = 0;

	public static void main(String[] args) {
		int tot = 0;
		for (int i = 0; i < numbers.length; i++) {
			tot += numbers[i];
		}
		for (int i = 0; i <= numbers.length; i++) {
			back(0, 0, target, numbers, tot, i);
		}
		System.out.println(answer);
	}

	static void back(int depth, int start, int target, int[] numbers, int tot, int cnt) {
		if (tot < target) { // 가지치기
			return;
		}

		if (depth == cnt) {// 기저조건
			if (tot == target) {
				answer++;
			}
			return;
		}
		for (int i = start; i < numbers.length; i++) {
			back(depth + 1, i + 1, target, numbers, tot - numbers[i]*2, cnt);
		}
	}
}
