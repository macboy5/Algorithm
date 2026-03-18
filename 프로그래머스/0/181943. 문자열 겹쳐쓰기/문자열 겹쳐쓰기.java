class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        int ow_length = overwrite_string.length();
        int my_length = my_string.length();
        
        for(int i=0; i<s; i++){
            char tmp = my_string.charAt(i);
            answer += tmp;
        }
        
        for(int i=0; i<ow_length; i++){
            char tmp = overwrite_string.charAt(i);
            answer += tmp;
        }
        
        if(s+ow_length < my_length){
        for(int i=s+ow_length; i<my_length; i++){
            char tmp = my_string.charAt(i);
            answer += tmp;
        }
        }

        
        return answer;
    }
}