import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        HashMap<String, Character> hm = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        
        for(String s : strings){
            char c = s.charAt(n);
            hm.put(s, c);
            list.add(s);
        }
        
        list.sort( (s1, s2) -> {
            if ( hm.get(s1) == hm.get(s2)){
                return s1.compareTo(s2);
            }
            else return hm.get(s1)-hm.get(s2);
        });
        
        answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        
        return answer;
    }
}