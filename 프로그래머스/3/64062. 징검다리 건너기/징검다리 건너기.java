import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        
        
        while(left <= right){
            int mid = (left+right)/2;
            
            if( canCross(stones, k , mid) ){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
                
            }
            
        }        
        
        return answer;
    }
    
private boolean canCross(int[] stones, int k, int mid) {
        int continuousZeros = 0; 
        
        for (int stone : stones) {            
            if (stone - mid < 0) {
                continuousZeros++;
            } else {
                continuousZeros = 0; 
            }
            
            if (continuousZeros >= k) {
                return false;
            }
        }
        
        return true;
    }
}