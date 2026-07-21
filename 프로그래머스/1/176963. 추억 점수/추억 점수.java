import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        answer = new int[photos.length];
        
        int idx = 0;
        for(String[] photo : photos){
            int sum = 0;
            for(String p : photo){
                sum += map.getOrDefault(p, 0);
            }
            answer[idx++] = sum;
        }
        
        
        return answer;
    }
}