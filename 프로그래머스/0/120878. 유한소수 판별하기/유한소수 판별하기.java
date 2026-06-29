class Solution {
    public int solution(int a, int b) {
        
        int common = gcd(a,b);
        
        a /= common;
        b /= common;
                
        return func(b) ? 1 : 2;
    }
    
    public int gcd(int a, int b){
        
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    public boolean func(int x){
        
        while(x>1){
            if(x%2==0){
                x/=2;
            }
            else if(x%5==0){
                x/=5;
            }
            else break;
        }
        
        if(x == 1) return true;
        
        return false;
        
    }
}