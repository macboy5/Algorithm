class Solution {
    public int[] solution(int[] arr, int[][] queries) {


        int idx = queries.length;
        int [] answer = new int[idx];
        
        for(int j=0; j<idx; j++){
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];
            int flag = -1;
            int min = 1000001;
            for(int i=s ; i<=e ; i++){
                if(arr[i]>k && min > arr[i]){
                    min = arr[i];
                    flag = 1;
                }
            }
            
            if(flag == -1) answer[j] = -1;
            else answer[j] = min;
            
        }
        
        return answer;
    }
}