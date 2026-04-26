class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        int length = rsp.length();
        
        for(int i=0; i<length; i++){
            char c = rsp.charAt(i);
            if(c == '2') answer += "0";
            else if(c == '0') answer+= "5";
            else if(c== '5') answer += "2";
        }
        
        return answer;
    }
}