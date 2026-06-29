class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling){

            int len = b.length();
            String tmp = "";
            boolean flag = true;
            
            for(int i=0; i<len; i++){
                tmp += b.charAt(i);

                
                if(tmp.length() == 2){
                    if(tmp.equals("ye") || tmp.equals("ma")){
                        tmp = "";
                    }
                }
                if(tmp.length() == 3){
                    if(tmp.equals("aya") || tmp.equals("woo")){
                        tmp = "";
                    }
                    else{
                        flag = false;
                        tmp = "";
                        break;
                    }
                }

            }
            
            if(!tmp.isEmpty()) continue;
            
            if(flag) answer++;
        
            
            
        }
        
        
        return answer;
    }
}