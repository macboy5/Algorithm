class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long left = 1;
        long right = 1000000000000000L; // 최대 시간
        long answer = 1000000000000000L;
        
        while(left <= right){
            long mid = (left+right)/2;
            
            long gold = 0;
            long silver = 0;
            long sum = 0;
            
            for(int i=0; i<g.length; i++){
                
                int nowG = g[i];
                int nowS = s[i];
                int nowW = w[i];
                int nowT = t[i];
                
                long cnt = mid/(nowT * 2);
                
                if( mid%(nowT*2) >= nowT) cnt++; 
                
                gold += Math.min(nowG, nowW * cnt);
                silver += Math.min(nowS, nowW * cnt);
                sum += Math.min(nowG + nowS, nowW * cnt);                       
            }
            
            if( a <= gold && b <= silver && (a+b) <= sum){
                answer = Math.min(answer, mid);
                right = mid - 1;
                
            }
            else{
                left = mid + 1;
            }
            
            
            
            
        }
        
        
        return answer;
    }
}