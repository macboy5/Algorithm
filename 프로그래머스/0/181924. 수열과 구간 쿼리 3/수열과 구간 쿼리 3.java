class Solution {
    
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        int idx = queries.length;
        
        for(int i=0; i<idx ; i++){
            
            int x = queries[i][0];
            int y = queries[i][1];
            
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
            
        }
        
        answer = arr;
        
        return answer;
    }
}