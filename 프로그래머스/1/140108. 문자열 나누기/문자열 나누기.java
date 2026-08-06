class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int cnt1 = 0, cnt2=0;
        
        char init = s.charAt(0);
        boolean flag = false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == init){
                cnt1++;
            }
            else cnt2++;
            
            if(cnt1 == cnt2){
                answer++;
                if(i != s.length()-1) init = s.charAt(i+1);
                continue;
            }
            
            if(i == s.length()-1){
                answer++;
            }
            
        }
        
        return answer;
    }
}