class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String tmp = Integer.toString(order);
        
        for(int i=0; i<tmp.length(); i++){
            char c = tmp.charAt(i);
            
            if(c == '3' || c=='6' || c=='9') answer++;
        }
        
        return answer;
    }
}