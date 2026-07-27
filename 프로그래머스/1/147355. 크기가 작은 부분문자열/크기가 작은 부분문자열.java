class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        long pVal = Long.parseLong(p); 
        
        for (int i = 0; i <= t.length() - len; i++) {
            
            long tVal = Long.parseLong(t.substring(i, i + len));
            
            if (tVal <= pVal) {
                answer++;
            }
        }
        
        return answer;
    }
}