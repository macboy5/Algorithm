import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n>0){
            int tmp = n%10;
            answer += tmp;
            n /= 10;
        }
        
        return answer;
    }
}