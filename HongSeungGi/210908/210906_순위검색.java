import java.util.*;
class Solution {
    public static Map<String, ArrayList<Integer>> infoMap = new HashMap<>(); 
    public static void comb(String[] arr, int idx, String check){
        String str = String.join("",arr);
        System.out.println(str);
        if(infoMap.containsKey(str) == false){
            ArrayList<Integer> list = new ArrayList<>();
            //System.out.println(arr[4]);
            list.add(Integer.parseInt(arr[4]));
            infoMap.put(str, list);
        }
        else{
            infoMap.get(str).add(Integer.parseInt(arr[4]));
        }
        for(int i = idx; i < arr.length-1; i++){
            String[] temp = Arrays.copyOf(arr, arr.length);
            temp[i] = "-";
            comb(temp, idx+1, check);
        }
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        answer = new int[query.length];
        for(int i = 0; i < info.length; i++){
            String[] arr = info[i].split(" ");
            comb(arr,0,"");
        }
        for(String key : infoMap.keySet()){
            Collections.sort(infoMap.get(key), (a,b)->{
                return a-b;
            });
        }
        int num = 0;
        for(String s : query){
            String str = "";
            String[] v = s.split(" ");
            for(int i = 0; i < v.length-1; i++){
                if(v[i].equals("and")) continue;
                str += v[i];
            }
            int target = Integer.parseInt(v[v.length-1]);
            ArrayList<Integer> check = infoMap.get(str);
            if(check == null){
                answer[num] = 0;
                num++;
                continue;
            }
            //System.out.println(check);
            int start = 0;
            int last = check.size()-1;
            while(start <= last){
                int mid = (start+last)/2;
                
                if(check.get(mid)<target){
                    start = mid+1;
                }
                else{
                    last = mid-1;
                }
            }
            answer[num] = check.size()-start;
            num++;
        }
        return answer;
    }
}