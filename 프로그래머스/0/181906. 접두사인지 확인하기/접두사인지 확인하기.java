import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        int len = my_string.length();
        
        for(int i=0; i<len; i++){
            String tmp = "";
            tmp = my_string.substring(0, i);
            list.add(tmp);
        }
        
        for(String s : list){
            if(s.equals(is_prefix)) return 1;
        }
        
        return answer;
    }
}