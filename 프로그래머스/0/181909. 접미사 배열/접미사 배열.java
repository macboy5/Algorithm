import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        
        ArrayList<String> list = new ArrayList<>();
        
        int len = my_string.length();
        
        for(int i=0; i<len; i++){
            
            String tmp = "";
            tmp = my_string.substring(i);
            
            list.add(tmp);
            
        }
        
        String[] answer = list.toArray(new String[0]);
        
        Arrays.sort(answer);
        
        return answer;
    }
}