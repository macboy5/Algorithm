class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int len = nums.length;
        
        for(int i=0; i<len ; i++){
            int n1 = nums[i];
            for(int j=i+1; j<len; j++){
                int n2 = nums[j];
                for(int k=j+1; k<len; k++){
                    int n3 = nums[k];
                    
                    int n = n1+n2+n3;
                    if(isPrime(n)) answer++;
                    
                }
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
    
}