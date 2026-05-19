class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for(String e1 : s1){
            for(String e2 : s2){
                if(e1.equals(e2)) answer++;
            }
        }
        
        return answer;
    }
}