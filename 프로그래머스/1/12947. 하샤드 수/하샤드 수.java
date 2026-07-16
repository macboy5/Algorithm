class Solution {
    public boolean solution(int x) {

        int total = 0;
        
        int num = x;
        
        while(num>0){
            
            total += num%10;
            num /= 10; 
            
            
        }
        
        if(x%total == 0) return true;
        else return false;

    }
}