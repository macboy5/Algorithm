import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n>0){
            int top = pq.poll()-1;
            n--;
            if(top>0){
                pq.add(top);
            }
            if(pq.isEmpty()) return 0;
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer += Math.pow(cur,2);
        }
        
    
        
        
        return answer;
    }
}