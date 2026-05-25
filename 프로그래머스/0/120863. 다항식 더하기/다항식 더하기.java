class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] token = polynomial.split(" ");
        
        int xCnt = 0;
        int num = 0 ;
        
        for(String t : token){
            int len = t.length();
            
            if(len == 1){
                char c = t.charAt(0);
                if(c == 'x') xCnt++;
                if(c >= '1' && c<='9') num += c -'0';
                else continue;
            }
            else {
                char c = t.charAt(len-1);
                if(c == 'x'){
                    String tmp = "";
                    for(int i=0; i<len-1; i++){
                        tmp += t.charAt(i);
                    }
                    xCnt += Integer.parseInt(tmp);
                    
                }
                else{
                    num += Integer.parseInt(t);
                }
                
            
            }
            
        }
        
        if(num == 0 && xCnt > 1){
            answer += xCnt;
            answer += "x";            
        }
        else if(xCnt == 0 && num != 0){
            answer += num;            
        }
        else if(xCnt == 1 && num==0){
            answer = "x";
        }
        else if(xCnt == 1&& num !=0){
            answer += "x + ";
            answer += num;
        }
        else{
            answer += xCnt;
            answer += "x + ";
            answer += num;
        }
        
        
        
        
        return answer;
    }
}