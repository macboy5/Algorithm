import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
    
        HashMap<Character, Integer> map = new HashMap<>();
        
        int idx = 0;
        for(char c : skill.toCharArray()){
            map.put(c, idx++);
        }
        
        for(String skill_tree : skill_trees){
            int seq = 0; 
            boolean isOk = true;
            for(char c : skill_tree.toCharArray()){
                int value = map.getOrDefault(c, -1);
                if(value == -1) continue;
                else if(value == seq++) continue;
                else{
                    isOk = false;
                    break;
                }
            }
            if(isOk) answer++;
        }
        
        
        return answer;
    }
}