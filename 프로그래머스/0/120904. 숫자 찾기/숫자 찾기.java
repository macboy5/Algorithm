import java.util.*;

class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        int cnt = 0;
        
        int len = String.valueOf(num).length();
        
        while(num > 0){
            if(num%10 == k){
                answer = len-cnt;
            }
            num /=10;
            cnt++;
        }
        
        return answer;
    }
}