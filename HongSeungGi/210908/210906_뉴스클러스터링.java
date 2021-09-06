import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> ans1 = new ArrayList<>();
        ArrayList<String> ans2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            if((int)a >= 65 && (int)a <= 90 && (int)b >= 65 && (int)b <= 90){
                String str = "";
                str += a;
                str += b;
                ans1.add(str);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            if((int)a >= 65 && (int)a <= 90 && (int)b >= 65 && (int)b <= 90){
                String str = "";
                str += a;
                str += b;
                ans2.add(str);
            }
        }
        if(ans1.size() == 0 && ans2.size() == 0){
            return answer = 65536;
        }
        ArrayList<String> ans3 = new ArrayList<>();
        ans3.addAll(ans2);
        double count = 0;
        for(int i = 0; i < ans1.size(); i++){
            for(int j = 0; j < ans3.size(); j++){
                if(ans1.get(i).equals(ans3.get(j))){
                    //System.out.println("tlfgod");
                    ans3.remove(j);
                    count++;
                    break;
                }
            }
        }
        if(count == 0){
            return answer = 0;
        }
        double total = ans1.size()+ans2.size()-count;
        //System.out.print(total);
        double ja = (count/total)*65536;
        return answer = (int)ja;
    }
}