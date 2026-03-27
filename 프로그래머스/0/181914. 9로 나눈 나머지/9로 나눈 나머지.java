class Solution {
    public int solution(String number) {
        int answer = 0;
        
        int length = number.length();
        
        for(int i=0; i<length; i++){
            char tmp = number.charAt(i);
            
            answer += tmp - '0';
        }
        
        answer %= 9;
        
        
        return answer;
    }
}