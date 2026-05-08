class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char c;
        String tmp = "";
        Integer before = 0;
        
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            
            if( c >= '0' && c<= '9' || c == '-'){
                tmp += c;
            }
            else if(c == 'Z'){
                answer -= before;
                before = 0;
            }
            else if(c == ' ' && tmp != ""){
                before = Integer.parseInt(tmp);
                answer += before;
                tmp = "";
            }
            
            if(i== s.length()-1 && tmp != ""){
                before = Integer.parseInt(tmp);
                answer += before;
            }
        }
        
        
        
        return answer;
    }
}