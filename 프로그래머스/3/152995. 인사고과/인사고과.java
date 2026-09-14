import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int baseAttitude = scores[0][0];
        int baseCoworker = scores[0][1];
        int baseSum = baseAttitude + baseCoworker;
        
        Arrays.sort(scores, (a,b) -> {
            
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
            
        });
        
        int maxCoworker = 0;
         
        for(int[] score : scores){
            
            if(score[1] < maxCoworker){
                if(score[0] == baseAttitude &&
                  score[1] == baseCoworker){
                    return -1;
                }
            }
            else{
                maxCoworker = Math.max(maxCoworker, score[1]);
                if(score[0] + score[1] > baseSum){
                    answer++;
                }
            }
            
        }
        
        
        return answer;
    }
}