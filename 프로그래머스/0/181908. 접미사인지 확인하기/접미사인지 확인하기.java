import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        
        int len = my_string.length();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            String tmp = "";
            tmp = my_string.substring(i);
            list.add(tmp);
        }
        
        for(String s : list){
            if(s.equals(is_suffix)) return 1;
        }
        
        return answer;
    }
}