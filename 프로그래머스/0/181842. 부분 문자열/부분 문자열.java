class Solution {
    public int solution(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        
        for(int i=0; i<= len2-len1; i++){
            String tmp = "";
            for(int j=0; j<len1; j++){
                tmp += str2.charAt(i+j);
            }
            if(tmp.equals(str1)) return 1;
            
        }
        
        return 0;
    }
}