
class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = {};
        
        int length = arr.length;
        answer = new int[length];
        
        if(length %2 == 0){
            for(int i=0; i<length; i++){
                if(i %2 != 0){
                    arr[i] += n;
                }
            }
        }
        else{
            for(int i=0; i<length ; i++){
                if( i%2 == 0){
                    arr[i] += n;
                }
            }
        }
        
        answer = arr.clone();
        
        return answer;
    }
}