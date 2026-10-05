import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int m = cores.length;
        if(n <= m) return n;
        
        int left = 1;
        int right = 10000 * n/m;
        int target = 0;
        
        while(left <= right){
            
            int mid = (left + right)/2;
            int cnt = m;
            for(int core : cores){
                cnt += mid / core;
            }
            
            if(cnt >= n){
                target = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;              
            }
        }
        
        int sum = m;
        
        for(int core : cores){
            sum += (target-1)/core;
        }
        
        n -= sum;
        for (int i = 0; i < m; i++) {
                    if ( target % cores[i] == 0) {
                        n--;
                        if (n==0) {
                            return i + 1; 
                        }
                    }
                }
        
        
        
        return answer;
    }
}