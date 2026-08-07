import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        int len = message.length();
        
        boolean[] isSpoiler = new boolean[len];
        
        for(int[] spoiler : spoiler_ranges){
            for(int i=spoiler[0]; i<= spoiler[1]; i++){
                isSpoiler[i] = true;
            }
        }
        
        HashSet<String> important = new HashSet<>();
        HashSet<String> normal = new HashSet<>();
        
        int start = 0, end = 0;
        
        while(start < len){
            
            if(message.charAt(start)==' '){
                start++;
                continue;
            }
            
            end = start;
            while(end < len && message.charAt(end) != ' '){
                end++;
            }
            
            String word = message.substring(start, end);
            
            boolean hasSpoiler = false;
            
            for(int i =start; i< end; i++){
                if(isSpoiler[i]){
                    hasSpoiler = true;
                    break;
                }
            }
            
            if(hasSpoiler){
                if(!normal.contains(word)){
                    important.add(word);
                }
            }
            else{
                normal.add(word);
                important.remove(word);
            }
            
            start = end;
            
        }
        
        
        answer = important.size();
        
        return answer;
    }
}