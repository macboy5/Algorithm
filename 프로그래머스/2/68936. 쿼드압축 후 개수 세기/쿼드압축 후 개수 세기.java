class Solution {
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int N = arr.length;
        
        quadzip(0,0,N,arr);
        
        return answer;
    }
    
    private void quadzip(int r, int c, int n, int[][]arr){
        
        if(compress(r,c, n, arr[r][c], arr)){
            if(arr[r][c] == 1){
                answer[1]++;
            }
            else answer[0]++;
            
            return;
        }
        
        quadzip(r, c , n/2, arr);
        quadzip(r+n/2, c, n/2, arr);
        quadzip(r, c+n/2, n/2, arr);
        quadzip(r+n/2, c+n/2, n/2, arr);
        
        
    }
    
    private boolean compress(int r, int c, int n, int value, int[][]arr){
        
        for(int i=r; i<r+n; i++){
            for(int j=c; j<c+n; j++){
                if(arr[i][j] != value) return false;
            }
        }
        
        return true;       
    }
}