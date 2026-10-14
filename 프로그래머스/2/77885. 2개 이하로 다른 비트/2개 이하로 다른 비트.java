class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        
        for(long number : numbers){
            
            if(number%2 ==0 ){
                answer[idx++] = number+1;

            }
            else{

                String binary = Long.toBinaryString(number);
                char[] bits = ("0" + binary).toCharArray();
                
                for(int j=bits.length-1; j>=0; j--){
                    if(bits[j] == '0'){
                        bits[j] = '1';
                        bits[j+1] = '0';
                        break;
                    }
                }
                
                answer[idx++] = Long.parseLong(new String(bits), 2);    
            }
            
    
        }
        
        return answer;
    }
}