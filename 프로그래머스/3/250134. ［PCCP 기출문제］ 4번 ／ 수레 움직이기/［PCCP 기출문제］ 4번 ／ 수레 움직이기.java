class Solution {
    
    static int[] dr = {-1,+1,0,0};
    static int[] dc = {0,0,-1,+1};
    
    static int n,m;
    static boolean[][] redVisited, blueVisited;
    static int redEndR, redEndC, blueEndR, blueEndC;
    static int answer;
    
    public int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;
        
        n = maze.length;
        m = maze[0].length;
        
        int redStartR = 0, redStartC = 0, blueStartR = 0, blueStartC = 0;
        
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j] == 1){ redStartR = i; redStartC = j;}
                if(maze[i][j] == 2){ blueStartR = i; blueStartC = j;}
                if(maze[i][j] == 3){ redEndR = i; redEndC = j;}
                if(maze[i][j] == 4){ blueEndR = i; blueEndC = j;}
            }
        }
        
        redVisited[redStartR][redStartC] = true;
        blueVisited[blueStartR][blueStartC] = true;
        
        dfs(maze, redStartR, redStartC, blueStartR, blueStartC, 0);
        
        
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void dfs(int[][]maze, int rR, int rC, int bR, int bC, int cnt){
        boolean redArrived = (rR == redEndR && rC == redEndC);
        boolean blueArrived = (bR == blueEndR && bC == blueEndC);
        
        if(redArrived && blueArrived){
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(cnt >= answer) return;
        
        
        for(int rDir = 0; rDir < 4; rDir++){
            for(int bDir = 0; bDir < 4 ; bDir++){
                
                int nrR = redArrived ? rR : rR + dr[rDir];
                int nrC = redArrived ? rC : rC + dc[rDir];
                
                int nbR = blueArrived ? bR : bR + dr[bDir];
                int nbC = blueArrived ? bC : bC + dc[bDir];
                
                // 레드 아직 도착 x, but 이동 불가
                if( !redArrived && !canMove(maze, nrR, nrC, redVisited)) continue;
                
                // 블루 아직 도착 x but 이동 불가
                if( !blueArrived && !canMove(maze, nbR, nbC, blueVisited)) continue;
                
                // 같은 곳으로 이동 불가
                if(nrR == nbR && nrC == nbC) continue;
                
                // 서로의 위치로 이동불가( 크로스 불가)
                if(nrR == bR && nrC == bC && nbR == rR && nbC == rC) continue;
                
                if(!redArrived) redVisited[nrR][nrC] = true;
                if(!blueArrived) blueVisited[nbR][nbC] = true;
                
                dfs(maze, nrR, nrC, nbR, nbC, cnt+1);
                
                if(!redArrived) redVisited[nrR][nrC] = false;
                if(!blueArrived) blueVisited[nbR][nbC] = false;
                 
                if(blueArrived) break;
                
            }
            if(redArrived) break;
        }
        
        
    }
    
    private boolean canMove(int[][] maze, int r, int c, boolean[][] visited){
        if(r<0 || r>=n || c<0 || c>= m) return false;
        if(maze[r][c] ==5) return false;
        if(visited[r][c]) return false;
        return true;
    }
}