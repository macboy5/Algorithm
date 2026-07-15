import java.util.*;


class Solution {
    public long[] solution(long n) {
        long[] answer = {};
        
        ArrayList<Long> list = new ArrayList<>();
        
        while(n>0){
            
            long tmp = n%10;
            
            list.add(tmp);
            n /= 10;
        }
        
        answer = new long[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}