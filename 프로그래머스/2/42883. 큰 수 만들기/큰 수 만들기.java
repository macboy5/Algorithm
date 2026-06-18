import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        
        // 스택에 넣고 스택의 top이 현재보다 작으면 pop한다
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : number.toCharArray()){
            
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                while(!stack.isEmpty() && stack.peek()<c && cnt < k){
                    stack.pop();
                    cnt++;
                }
                stack.push(c);
            }
            
        }
        
        while(cnt++ < k && !stack.isEmpty()){
            stack.pop();
        }
        
        while(!stack.isEmpty()){
            char c = stack.peek();
            answer += c;
            stack.pop();
        }
        
        // System.out.println(answer);
        
        String tmp = "";
        
        int len = answer.length();
        
        for(int i=len-1; i>=0; i--){
            tmp += answer.charAt(i);
        }
        
        
        return tmp;
    }
}