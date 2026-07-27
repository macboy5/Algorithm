class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};
        
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        
        int a=0, b=0;
        
        for(int i=1; i<=min; i++){
            if(n%i == 0 && m%i ==0) a = i;
        }
        
        b = a* n/a * m/a ;
        
        answer = new int[]{a,b};
        
        return answer;
    }
}