import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        char[][] map = new char[row][col];
        
        for(int i = 0; i < row; i++){
            map[i] = maps[i].toCharArray();
        }
                
        // S -> L까지 최단 경로
        int a = pathFind('S', 'L', map, row, col);
        // L -> E까지 최단 경로
        int b = pathFind('L', 'E', map, row, col);
        
        if(a != -1 && b != -1){
            return a + b;
        } else {
            return -1;
        }
    }
    
    public int pathFind(char start, char end, char[][] map, int row, int col){
        boolean[][] isVisited = new boolean[row][col];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j] == start){
                    q.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(map[x][y] == end) return dist[x][y];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < row && ny >= 0 && ny < col && !isVisited[nx][ny] && map[nx][ny] != 'X'){
                    isVisited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
}