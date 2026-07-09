import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {

        ArrayList<Integer> list = new ArrayList<>();
        
        int len = intStrs.length;
        
        for(String s1 : intStrs){
            String tmp = s1.substring(s, s+l);
            int num = Integer.parseInt(tmp);
            if(k < num){
                list.add(num);    
            }
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        
        return answer;
    }
}