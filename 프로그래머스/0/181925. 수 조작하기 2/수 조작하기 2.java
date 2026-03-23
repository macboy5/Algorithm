class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        int length = numLog.length;
        
        for(int i=1; i<length; i++){
            int diff = numLog[i] - numLog[i-1];
            if(diff == 1) answer += "w";
            if(diff == -1) answer += "s";
            if(diff == 10) answer += "d";
            if(diff == -10) answer += "a";
        }
        
        return answer;
    }
}