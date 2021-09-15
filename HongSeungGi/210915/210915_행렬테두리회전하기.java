class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int num = 1;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            int[] points = queries[i];
            
            int x1 = points[0];
            int y1 = points[1];
            int x2 = points[2];
            int y2 = points[3];
            
            int cur = arr[x1-1][y1-1];
            int next = 0;
            int min = cur;
            
            for(int j = y1; j < y2; j++){
                next = arr[x1-1][j];
                arr[x1-1][j] = cur;
                cur = next;
                if(min > next) min = next;
            }
            for(int j = x1; j < x2; j++){
                next = arr[j][y2-1];
                arr[j][y2-1] = cur;
                cur = next;
                if(min > next) min = next;
            }
            for(int j = y2-2; j >= y1-1; j--){
                next = arr[x2-1][j];
                arr[x2-1][j] = cur;
                cur = next;
                if(min > next) min = next;
            }
            for(int j = x2-2; j >= x1-1; j--){
                next = arr[j][y1-1];
                arr[j][y1-1] = cur;
                cur = next;
                if(min > next) min = next;
            }
            answer[i] = min;
        }
        return answer;
    }
}