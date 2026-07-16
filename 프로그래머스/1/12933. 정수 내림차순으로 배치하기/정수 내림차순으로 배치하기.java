import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        ArrayList<Long> list = new ArrayList<>();
        
        while(n>0){
            long remainder = n%10;
            list.add(remainder);
            n/= 10;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        String tmp = "";
        
        for(int i=0; i<list.size(); i++){
            tmp += String.valueOf(list.get(i));
        }
        
        answer = Long.parseLong(tmp);      
        
        
        return answer;
    }
}