import java.util.*;

class Solution {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[][] map = new int[4][3];
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
    
        int n = 1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map[i][j] = n++;
            }
        }
        map[3][0] = -99;
        map[3][1] = 0; 
        map[3][2] = -99;
        
        int left_x = 3, left_y=0, right_x=3, right_y=2;
        
        for(int number : numbers){
            
            int x = -1, y=-1;
            for(int i=0; i<4; i++){
                for(int j=0; j<3; j++){
                    if(map[i][j] == number){
                        x = i;
                        y=j;
                        break;
                    }
                }
            }
            
            switch(number){
                case 1,4,7 -> {
                    answer += "L";
                    left_x = x;
                    left_y = y;
                }
                case 3,6,9 -> {
                    answer += "R";
                    right_x = x;
                    right_y = y;
                }
                case 2,5,8,0 ->{
                    // L에서의 거리
                    int disL = bfs(x,y,left_x,left_y);
                    // R에서의 거리
                    int disR = bfs(x,y,right_x,right_y);
                    
                    if(disL == -1 && disR == -1){
                        continue;
                    }
                    else if(disL == -1 && disR !=-1){
                            right_x = x;
                            right_y =y;
                            answer +=  "R";
                    }
                    else if(disL != -1 && disR == -1){
                            left_x = x;
                            left_y =y;   
                            answer +=  "L";
                    }
                    else{
                    
                    
                    if(disL>disR){
                        right_x = x;
                        right_y =y;
                        answer +=  "R";
                    }
                    else if(disL < disR){
                        left_x = x;
                        left_y =y;
                        answer +=  "L";
                    }
                    else if(disL == disR){
                        if(hand.equals("right")){
                            right_x = x;
                            right_y =y;
                            answer +=  "R";
                        }
                        else if(hand.equals("left")){
                            left_x = x;
                            left_y =y;   
                            answer +=  "L";
                        }
                    }
                }
            }
            }
        }
    
        
        
        return answer;
    }
    
    public int bfs(int x, int y, int hand_x, int hand_y){
        
        if(x == hand_x && y == hand_y){
                return 0;
            }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{hand_x, hand_y , 0});
        boolean isVisited[][] = new boolean[4][3];
        isVisited[hand_x][hand_y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int distance = cur[2];
            if(cur_x == x && cur_y == y){
                return distance;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                
                if(nx>=0 && nx<4 && ny>=0 && ny<3
                  && !isVisited[nx][ny]){
                    q.add(new int[]{nx,ny, distance+1});
                    isVisited[nx][ny] = true;
                    
                }
                
            }
            
            
        }
        
        return -1;
    }
    
}