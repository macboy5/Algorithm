import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] strArr = my_string.split(" ");
        Queue<Integer> q = new ArrayDeque<>();
        int flag = 1;
        
        for(String s : strArr){
            if(s.equals("+")){
                continue;
            }
            else if (s.equals("-")){
                flag = -1;
            }
            else{
                int num = Integer.parseInt(s) * flag;
                flag = 1;
                q.add(num);
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            answer += cur;
        }
        
        
        
        
        return answer;
    }
}