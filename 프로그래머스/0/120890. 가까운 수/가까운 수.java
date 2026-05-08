class Solution {
    public int solution(int[] array, int n) {
        int answer = 100;
        
        int min = 100;
        
        
        for(int i=array.length-1; i>=0; i--){
            int tmp = array[i];
            if(min > Math.abs(tmp - n)) {
                min = Math.abs(tmp - n);
                answer = tmp;
                                       }
            if(min == Math.abs(tmp-n)){
                answer = Math.min(tmp, answer);
            }
        }
        
        
        return answer;
    }
}