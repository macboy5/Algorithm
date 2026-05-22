class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String tmp = "";
        
        
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c >= '0' && c<='9'){
                tmp += c;
            }
            else{
                if(tmp.length() != 0){
                    answer += Integer.parseInt(tmp);
                    tmp = "";
                }
            }
        }
        if(tmp.length() != 0){
            answer += Integer.parseInt(tmp);
        }
        
        return answer;
    }
}