import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        List<String> list = new ArrayList<>();
        String tmp = "";
        for(int i=0; i<myStr.length(); i++){
            char c = myStr.charAt(i);
            if(c =='a' || c =='b' || c=='c'){
                if(tmp.length()>0){
                    list.add(tmp);
                    tmp = "";
                }
                
                continue;
            }
            else tmp += c;
        }
        if(tmp.length()>0) list.add(tmp);
        
        if(list.isEmpty()) list.add("EMPTY");
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}