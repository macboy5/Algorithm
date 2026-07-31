import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        boolean[][] isVisited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                int sizeOfOneArea = 0;
                if(!isVisited[i][j] && picture[i][j] !=0){
                    numberOfArea++;
                    
                    int color = picture[i][j];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    sizeOfOneArea++;
                    
                    while(!q.isEmpty()){

                        int[] cur = q.poll();
                        int x = cur[0], y= cur[1];
                        
                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx>=0 && nx<m && ny>=0 && ny<n 
                               && !isVisited[nx][ny] 
                               && color==picture[nx][ny]){
                                q.add(new int[]{nx,ny});
                                isVisited[nx][ny] = true;
                                sizeOfOneArea++;
                            }
                        }
                        
                    }
                    
                }
                
                
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                        
            }
        }
        
        
        
        
        
        answer[0] = numberOfArea;   // 몇개의 영역이 있는지
        answer[1] = maxSizeOfOneArea; // 가장 큰 영역은 몇 칸인지
        
        return answer;
    }
}