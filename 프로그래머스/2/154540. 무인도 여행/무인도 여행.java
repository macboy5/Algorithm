import java.util.*;

class Solution {
    public int[] solution(String[] maps) {

        List<Integer> answerList = new ArrayList<>();      
        
        int row = maps.length;
        int col = maps[0].length();
        
        char[][] map = new char[row][col];
        boolean[][] isVisited = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!isVisited[i][j] && map[i][j] != 'X'){
                    int sum = bfs(i, j, map, isVisited, row, col);
                    answerList.add(sum);
                }
            }
        }
        
        if(answerList.isEmpty()){
            return new int[]{-1};
        }
        
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int startX, int startY, char[][] map, boolean[][] isVisited, 
                   int row, int col){
        
        int[] dx = new int[]{-1, +1, 0, 0};
        int[] dy = new int[]{0, 0, -1, +1};
        
        int sum = 0;
        
        isVisited[startX][startY] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        
        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            int x = cur[0];
            int y = cur[1];
            
            sum += (map[x][y] - '0');
            
     
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if(!isVisited[nx][ny] && map[nx][ny] != 'X') {
                        isVisited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return sum;
    }
}