class Solution {
    public String solution(String code) {
        String answer = "";
        
        int mode = 0;
        
        for(int i=0; i<code.length(); i++){
            char tmp = code.charAt(i);
            
            if(tmp == '1'){
                if(mode == 0) mode = 1;
                else mode = 0;
                continue;
            }
            else{
                if(mode ==0 && i%2==0) answer +=tmp;
                else if(mode == 1 && i%2 != 0) answer += tmp;
            }
            
        }
        
        if(answer == "") answer = "EMPTY";
        
        return answer;
    }
}