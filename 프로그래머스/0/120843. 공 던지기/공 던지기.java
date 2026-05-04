class Solution {
    public int solution(int[] numbers, int k) {
        int answer = numbers[0];
        int idx = 0;
        int maxIdx = numbers.length-1;
        
        for(int i=1; i<k; i++){
            if(idx+2 <=maxIdx){
                idx += 2;
            }
            else{
                idx +=2;
                idx -= maxIdx;
                idx--;
            }
        }
        
        answer = numbers[idx];
        
        return answer;
    }
}