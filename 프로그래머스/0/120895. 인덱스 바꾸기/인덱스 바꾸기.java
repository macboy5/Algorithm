class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        String s1="", s2="", s3="";
        char c1, c2;
        
        for(int i=0; i<num1; i++){
            s1 += my_string.charAt(i);
        }
        
        for(int i=num1+1; i<num2; i++){
            s2 += my_string.charAt(i);
        }
        
        for(int i=num2+1; i<my_string.length(); i++){
            s3 += my_string.charAt(i);
        }  
        
        c1 = my_string.charAt(num1);
        c2 = my_string.charAt(num2);
        
        answer += s1;
        answer += c2;
        answer += s2;
        answer += c1;
        answer += s3;
        
        
        return answer;
    }
}