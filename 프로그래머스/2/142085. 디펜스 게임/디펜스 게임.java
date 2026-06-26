import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(k == enemy.length) return k;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        for(int i=0; i<enemy.length; i++){
            int e = enemy[i];
            sum += e;
            pq.add(e);
            
            if(sum > n && k >0){
                int max = pq.poll();
                sum -= max;
                k--;
            }
            
            if(sum>n && k == 0){
                return i;
            }
            
        }
        
        if(k>=0) return enemy.length;
        
        return answer;
    }
}