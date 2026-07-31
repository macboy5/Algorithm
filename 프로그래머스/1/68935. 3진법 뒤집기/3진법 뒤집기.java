class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n<=3) return n;
        String tmp = "";
        
        while(n>0){
            int remainder = n%3;
            tmp += remainder;
            n/=3;
            if(n<3){ 
                tmp += n;
                break;
            }
        }
        
        //System.out.println("tmp : " + tmp);
        int len = tmp.length();
        
        char[] arr = tmp.toCharArray();
        for(int i=0; i<len; i++){
            answer += (arr[i] - '0') * Math.pow(3,len-i-1);
        }
        
        return answer;
    }
}