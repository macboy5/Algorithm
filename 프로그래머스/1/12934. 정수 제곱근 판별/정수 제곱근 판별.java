class Solution {
    public long solution(long n) {

        
        long num = 1;
        
        while(true){
            
            long tmp = num*num;
            if(tmp > n) return -1;
            else if(tmp == n){
                tmp = (num+1)*(num+1);
                return tmp;
            }
            else num++;
            
        }

    }
}