class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int minX = 256, maxX=-256, minY=256,maxY=-256;
        
        for(int[] dot : dots){
            int x = dot[0];
            int y = dot[1];
            
            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
            
        }
        
        answer = (maxX-minX) * (maxY-minY);
        
        return answer;
    }
}