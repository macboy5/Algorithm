class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int len = s.length();
        
        for(int i=0; i<len; i++){
            
            int len1 = expandFromCenter(s, i ,i);
            int len2 = expandFromCenter(s, i, i+1);
            
            int tmp = len1>len2?len1 : len2;
            
            answer = Math.max(answer, tmp);
            
        }
        
        

        return answer;
    }
    
    public static int expandFromCenter(String s, int left, int right){
        
        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return (right-1) - (left+1)+1;
        
    }
}