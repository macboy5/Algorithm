class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        int[] alphabet = new int[26];
        
        for(int i=0; i<skip.length(); i++){
            char c = skip.charAt(i);
  //          System.out.println(c);
  //          System.out.println(c-97);
            alphabet[c-97] = -1;
        }
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            int cnt = 0;
            int idx = c-97;
            while(cnt < index){
                idx++;
                if(idx == 26){
                    idx = 0;
                }
                
                if(alphabet[idx] ==0){ 
                    cnt++;
                }
                else continue;
                
                if(cnt==index) break;
            }
            // System.out.println(idx);
            char a = (char) (idx +97);
            answer += String.valueOf(a);
                        
        }
        
        return answer;
    }
}