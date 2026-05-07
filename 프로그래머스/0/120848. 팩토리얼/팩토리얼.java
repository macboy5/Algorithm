class Solution {
    public int solution(int n) {
        int answer = 0;
        int result = 1;
        int i = 1;
        
        while( n >= result){
            result *= ++i;
        }
        
        answer = i-1;
        
        return answer;
    }
}