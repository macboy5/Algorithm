import java.util.*;
class Solution {
    public String solution(String p) {
        return func(p);
    }
            
// 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
//   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
//   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
//   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
//   4-3. ')'를 다시 붙입니다. 
//   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
//   4-5. 생성된 문자열을 반환합니다.
    
    public String func(String p){

        if(p.length() == 0) return "";
        if(test(p)) return p;
        
        String u = "";
        String v = "";
        int openCnt = 0;
        int closeCnt = 0;
        int idx = -1;
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c == '('){
                openCnt++;
            }
            else closeCnt++;
                
            u += c;
            if(openCnt == closeCnt){ 
                idx = i;
                break;
            }
            }
            
        for(int i=idx+1; i< p.length(); i++){
            char c = p.charAt(i);
            v += c;
        }
            
        //  u : 올바른 문자열 검사
            
        if(test(u)){
            return u + func(v);
        }
        else{
            String tmp = "(";
            tmp += func(v);
            tmp += ")";
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i) == '(') tmp += ")";
                else tmp += "(";
            }
            return tmp;
        }
    }
    
    public boolean test(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            char top = st.peek();
            if(top == '(' && c == ')'){
                st.pop();
            }
            else st.push(c);
            
        }
        
        if(st.isEmpty()) return true;
        else return false;
        
        
    }
}