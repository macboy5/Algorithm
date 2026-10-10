import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (r1, r2) ->{
            return r1[1] - r2[1];
        });
        
        boolean[] visit = new boolean[routes.length];
        
        
        for(int i=0; i<routes.length; i++){
            if(visit[i]) continue;
            int point = routes[i][1];
            int cnt = 0;
            
            for(int j=i; j<routes.length; j++){
                int start = routes[j][0];
                int end = routes[j][1];
                if(start<=point && point <=end){
                    visit[j] = true;
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(cnt>0) answer++;
            
        }


        
        
        
        // 최소설치해야되는 카메라수
        return answer;
    }
}