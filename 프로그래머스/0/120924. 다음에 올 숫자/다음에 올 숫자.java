class Solution {
    public int solution(int[] common) {

        
        int len = common.length;
        
        int diff1 = common[1] - common[0];
        int diff2 = common[len-1] - common[len-2];
        
        if(diff1== diff2){
            return common[len-1]+diff1;
        }
        
        int mul1 = common[1]/common[0];
        
        return common[len-1]*mul1;

    }
}