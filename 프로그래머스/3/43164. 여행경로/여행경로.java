import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList<>();
    static boolean[] isVisited;
    
    public String[] solution(String[][] tickets) {
                
        isVisited = new boolean[tickets.length];
        dfs("ICN", "ICN", 0, tickets);
        
        
        // ICN 에서 출발해서 주어진 항공권 모두 사용후 경로 return
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    private void dfs(String now, String path, int depth, String[][] tickets){
        if(depth == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!isVisited[i] && tickets[i][0].equals(now)){
                isVisited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], depth+1, tickets);
                isVisited[i] = false;
            }
        }
        
    }
}