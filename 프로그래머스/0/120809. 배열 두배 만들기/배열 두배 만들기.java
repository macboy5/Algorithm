class Solution {
    public int[] solution(int[] numbers) {

        
        int cnt = numbers.length;
        int[] answer = new int[cnt];
        
        for(int i=0; i<cnt; i++){
            answer[i]=2*numbers[i];    
        }
        
        
        return answer;
    }
}