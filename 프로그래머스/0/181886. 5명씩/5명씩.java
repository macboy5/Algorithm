import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        String[] answer = {};
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=1; i<=names.length; i++){
            
            if(i%5 ==1){
                list.add(names[i-1]);
            }
            
        }
        
        answer = new String[list.size()];
        
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}