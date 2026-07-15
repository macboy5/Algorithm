import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        int rank =0;
        
        for(String player : players){
            map.put(player, rank++);
        }
        
        for(String calling : callings){
            
            int idx = map.get(calling);
            
            String tmp = players[idx-1];                       
            players[idx-1] = calling;
            players[idx] = tmp;
            
            map.put(calling, idx-1);
            map.put(tmp, idx);            
            
        }
        
        
        
        return players;
    }
}