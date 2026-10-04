import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 0~23시 게임이용자의 수 -> players

        // 증설 서버 종료 시각이 들어감
        Queue<Integer> q = new ArrayDeque<>();
       
        // 현재 증설된 서버수
        int cur = 0;
        
        for(int i=0; i<=23; i++){
            int player = players[i];
                     
            int server = player / m;
            if(cur < server){
                int tmp = cur;
                for(int j=0; j<server-tmp; j++){
                    q.add(i+k);
                    cur++;
                    answer++;
                }
            }
            
            while(!q.isEmpty() && q.peek()-1 == i){
                cur--;
                q.poll();
            }
        }
        
        return answer;
    }
}