
class Solution {
    //static boolean[] check;
    static int ans = 0;
    static void subset(int[] num, int count, int target, boolean[] check){
        if(count == num.length){
            int res = 0;
            for(int i = 0; i < num.length; i++){
                if(!check[i]){
                    res += num[i];
                    continue;
                }
                res -= num[i];
            }
            if(res == target) ans++;
            return;
        }
        check[count] = true;
        subset(num, count+1, target, check);
        check[count] = false;
        subset(num, count+1, target, check);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        boolean[] check = new boolean[numbers.length];
        subset(numbers, 0, target, check);
        answer = ans;
        
        return answer;
    }
}