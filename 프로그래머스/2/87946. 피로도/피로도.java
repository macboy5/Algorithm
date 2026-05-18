class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {

        
        dfs(k, dungeons, new boolean[dungeons.length]);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] visited){
        int cnt = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]) {
                cnt++;
            }
        }
        
        if(cnt > answer) answer =cnt;
        
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited);
                visited[i] = false;
                
            }
        }
        
        return;
    }
}