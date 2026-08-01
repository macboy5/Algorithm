class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for(int[] query : queries){
            int idx1= query[0], idx2 = query[1];
            for(int i=idx1; i<=idx2; i++){
                arr[i]++;
            }
        }
        
        return arr;
    }
}