class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char c;
        for(int i=0; i<my_string.length(); i++){
            c = my_string.charAt(i);
            if(c >= 'a' && c<= 'z') answer += Character.toUpperCase(c);
            else if(c >= 'A' && c<= 'Z') answer += Character.toLowerCase(c);
        }
        
        return answer;
    }
}