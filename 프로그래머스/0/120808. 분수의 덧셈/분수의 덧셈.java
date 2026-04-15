class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int numer3, denom3;
        
        numer3 = numer1*denom2 + numer2*denom1;
        denom3 = denom1*denom2;
        
        int tmp = 1;
        while(true){

        for(int i=2; i<=numer3; i++){
            if(numer3%i == 0 && denom3%i ==0) tmp = i;
        }
        if(tmp ==1 ) break;
        numer3 /= tmp;
        denom3 /= tmp;
        tmp = 1;
        }
        
        answer[0] = numer3;
        answer[1] = denom3;
        
        return answer;
    }
}