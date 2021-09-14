package 알고리즘스터디;

public class PRO_입국심사 {
	static int n = 6;
	static int[] times = { 7, 10 };

	public static void main(String[] args) {
		long left = 1;
        long right = n * (long)times[times.length - 1];
        long result = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            
            if (count < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                result = mid;
            }
          
        }
        System.out.println(result);
	}
}
