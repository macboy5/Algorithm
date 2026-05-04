class Solution {
    public int[][] solution(int[] num_list, int n) {
        int length = num_list.length;
        int col = n;
        int row = length/col;
        
        int[][] answer = new int [row][col];
        int idx = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                answer[i][j] = num_list[idx++];
            }
        }
    
        
        return answer;
    }
}