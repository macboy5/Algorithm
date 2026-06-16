import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 2 3 4
        // 1:1, 2:3, 3:4, 1:2의 비율을 만족시키는 몸무게 쌍의 갯수
        
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++){
            int w1 = weights[i];
            
            for(int j=i+1; j<weights.length; j++){
                int w2 = weights[j];
                
                if(w1 == w2) answer++;
                if(w1*2 == w2*3) answer++;
                if(w1*3 == w2*4) answer++;
                if(w1 == w2*2) answer++;
                if(w1*3 == w2*2) answer++;
                if(w1*4 == w2*3) answer++;
                if(w1*2 == w2) answer++;                
            }
            
        }
        
        
        
        return answer;
    }
}