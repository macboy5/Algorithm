import java.util.*;

class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,1,-1};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int row = land.length;
        int col = land[0].length;
        
        boolean[][] isVisited = new boolean[row][col];
        int[][] groupOil = new int [row][col]; 
        HashMap<Integer, Integer> groupSize = new HashMap<>();
        
        int groupId = 1;
        
        for(int i=0; i<row; i++){
            
            for(int j=0; j<col; j++){
                
                if( land[i][j]==1 && !isVisited[i][j]){
                    int cnt = 1;
                    Queue<int[]> q = new LinkedList<>();                               
                    q.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    groupOil[i][j] = groupId;
                    
                    while(!q.isEmpty()){
                        
                        int cur[] = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        
                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if(nx>=0&&nx<row&&ny>=0&&ny<col&&!isVisited[nx][ny] && land[nx][ny]==1){
                                q.add(new int[] {nx,ny});
                                isVisited[nx][ny] = true;
                                groupOil[nx][ny] = groupId;
                                cnt++;
                            }
                            
                        }
                        
                    }
                   // System.out.println("init cnt : " + cnt + " groupId : " + groupId);
                    groupSize.put(groupId, cnt);
                    groupId++;       
                }
            }          
            
        }
        
        for(int j=0; j<col; j++){
            HashSet<Integer> hs = new HashSet<>();
            int cnt = 0;
            for(int i=0; i<row; i++){
                
                if(groupOil[i][j] != 0){
                    int curId = groupOil[i][j];
                    
                    // System.out.println("curId : " + curId);
                    if(hs.contains(curId)){
                        continue;
                    }
                    else{
                        hs.add(curId);
                        cnt += groupSize.get(curId);
                    }
                }
                else continue;
            }
            
            
            answer = Math.max(answer, cnt);
        }
        
        
        return answer;
    }
}