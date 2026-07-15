import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character, Integer> hs = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            String word = survey[i];
            Character first = word.charAt(0);
            Character second = word.charAt(1);
            
            
            int choice = choices[i];
            if(choice>=1 && choice<=3){
                hs.put(first, hs.getOrDefault(first, 0) + 4-choice);
            }
            else if(choice>=5 && choice<=7){
              hs.put(second, hs.getOrDefault(second, 0) + choice-4);  
            } 
        }
        
        int R = hs.getOrDefault('R', 0);
        int T = hs.getOrDefault('T', 0);
        if(R>=T) answer += "R";
        else answer += "T";
        
                
        int C = hs.getOrDefault('C', 0);
        int F = hs.getOrDefault('F', 0);
        if(C>=F) answer += "C";
        else answer += "F";
        
                
        int J = hs.getOrDefault('J', 0);
        int M = hs.getOrDefault('M', 0);
        if(J>=M) answer += "J";
        else answer += "M";
        
        int A = hs.getOrDefault('A', 0);
        int N = hs.getOrDefault('N', 0);
        if(A>=N) answer += "A";
        else answer += "N";
        
        return answer;
    }
}