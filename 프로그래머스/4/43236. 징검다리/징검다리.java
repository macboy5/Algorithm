import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left = 1;
        int right = distance;
        
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid =(left+right)/2;
            int cnt = 0;
            int prev = 0;
            
            for(int i=0; i<rocks.length; i++){
                if( rocks[i] - prev < mid){
                    cnt++;
                }
                else{
                    prev = rocks[i];
                }
            }
            if(distance - prev < mid) cnt++;
            
            if(cnt > n){
                right = mid - 1;
            }
            else{
                left = mid + 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}