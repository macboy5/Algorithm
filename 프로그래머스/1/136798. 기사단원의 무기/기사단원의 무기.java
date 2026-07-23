import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=number; i++){
            int cnt = 0;
            for(int j=1; j<=i; j++){
                if(i%j == 0) cnt++;
            }
            list.add(cnt);
        }
        
        for(int i=0; i<list.size(); i++){
            int n = list.get(i);
            if(n>limit) answer += power;
            else answer += n;
        }
        
        
        return answer;
    }
}