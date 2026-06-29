class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int [] cnt = new int[201];
        
        for(int[] line : lines){
            int start = line[0];
            int end = line[1];
            
            for(int i=start; i<end; i++){
                cnt[i+100]++;
            }
            
        }
        
        for(int i=0; i<=200; i++){
            if(cnt[i]>1) answer++;
        }
        
        
        return answer;
    }
}