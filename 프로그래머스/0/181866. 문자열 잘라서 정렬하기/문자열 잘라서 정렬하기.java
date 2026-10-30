import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] tmp = myString.split("x");
        
        List<String> list = new ArrayList<>();
        for(String s : tmp){
            if(s.isEmpty()) continue;
            else list.add(s);
        }
        
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);       
        }
        
        Arrays.sort(answer);

        return answer;
    }
}