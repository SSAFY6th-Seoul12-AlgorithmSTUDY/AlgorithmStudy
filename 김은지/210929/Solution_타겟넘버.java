package programmers.dfsbfs;

public class Solution_타겟넘버 {
	
	static int cnt;

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
		//5
	}

	static int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
	
	static void dfs(int[] numbers, int target, int idx, int sum) {
		if (idx == numbers.length) {
			if (sum == target) cnt++;
			return;
		}
		
		dfs(numbers, target, idx+1, sum+numbers[idx]);
		dfs(numbers, target, idx+1, sum-numbers[idx]);
	}
}
