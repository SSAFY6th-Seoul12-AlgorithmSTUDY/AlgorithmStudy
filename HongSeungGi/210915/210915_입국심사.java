import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long min = 0;
        long max = (long)times[times.length-1]*n;
        answer = max;
        while(min <= max){
            long mid = (max+min)/2;
            long pass = 0;
            for(int i = 0; i < times.length; i++){
                pass += mid/times[i];
            }
            
            if(pass >= n){
                if(answer > mid){
                    answer = mid;
                }
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return answer;
    }
}