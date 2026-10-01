import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        
        String[] tmp = my_string.split(" ");
        List<String> list = new ArrayList<>();
        
        for(String t : tmp){
            if(t.length()>0){
                list.add(t);
            }
        }
        
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}