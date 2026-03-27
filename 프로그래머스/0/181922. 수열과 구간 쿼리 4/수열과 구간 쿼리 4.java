class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int[] q : queries){
            
            int s = q[0];
            int e = q[1];
            int k = q[2];
            
            for(int i=s; i<=e; i++){
                if(i==0) {
                    arr[0]++;        
                    continue;
                 }
                if(i%k == 0){
                    arr[i]++;
                }
            }
            
        }
        
        answer = arr;
        
        return answer;
    }
}