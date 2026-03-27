class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        int length = my_string.length();
        
        for( int[] q : queries){
            int s = q[0];
            int e = q[1];
            
            String tmp = "";
            for(int i=e; i>=s; i--){
                tmp += my_string.charAt(i);
            }
            
            String tmp1 ="";
            
            for(int i=0; i<s; i++){
                tmp1 += my_string.charAt(i);
            }
            
            tmp1 += tmp;
            
            for(int i=e+1; i<length; i++ ){
                tmp1 += my_string.charAt(i);
            }
            
            my_string = "";
            my_string += tmp1;
            
        }
        
        answer = my_string;
        
        return answer;
    }
}