class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                answer += ' ';
                continue;
            }
            else if(c >= 'A' && c<= 'Z'){
                c += n;
                if( c > 'Z'){
                    c -= 'Z';
                    c += 'A';
                    c--;
                }
                answer += c;
            }
            else if(c >= 'a' && c <= 'z'){
                c += n;
                if( c > 'z'){
                    c -= 'z';
                    c += 'a';
                    c--;
                }
                answer += c;
            }
            
        }
        
        return answer;
    }
}