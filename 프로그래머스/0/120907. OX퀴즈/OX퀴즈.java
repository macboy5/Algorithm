import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int idx = 0;
        for(String q : quiz){
            
            String[] tmp = q.split(" ");
            
            int num1 = Integer.parseInt(tmp[0]);
            int num2= Integer.parseInt(tmp[2]);
            String op = tmp[1];
            int num3 = Integer.parseInt(tmp[4]);
            
            
            int result = 0;
            
            if(op.equals("+")) result = num1 + num2;
            else if(op.equals("-")) result = num1-num2;
            
            if(num3== result) answer[idx++] = "O";
            else answer[idx++] = "X";
            

        }
        
        
        
        return answer;
    }
}