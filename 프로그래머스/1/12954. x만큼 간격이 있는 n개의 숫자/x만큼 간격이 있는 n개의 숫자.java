import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        
        ArrayList<Long> list = new ArrayList<>();
        
        for(int i=0; i<n ; i++){
            long tmp = (long)x*(i+1);
            list.add(tmp);
        }
        
        answer = new long[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}