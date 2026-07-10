class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        int len = my_string.length();
        
        for(int i=0; i<len; i++){
            if(i%m == c-1){
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}