import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        
        for(int i=l; i<=r ; i++){
            int tmp = i;
            
            while(tmp>0){
                if(tmp%10 == 0 || tmp%10 ==5){
                    tmp/=10;
                    continue;
                } 

                else break;
            }
            if(tmp ==0) list.add(i);
        
        }
        
        if(list.isEmpty()) list.add(-1);
        
int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}