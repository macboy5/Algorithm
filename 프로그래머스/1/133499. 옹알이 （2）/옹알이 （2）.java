class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String s : babbling){
            String tmp = "";
            int state = -1;
            boolean flag = false;
            for(int idx = 0; idx < s.length(); idx++){
                tmp += s.charAt(idx);
                
                if(tmp.length() == 2){
                    if(tmp.equals("ye") && state != 1 ){
                        tmp = "";
                        state = 1;
                        flag = true;
                    }
                    else if(tmp.equals("ma") && state != 2){
                        tmp = "";
                        state = 2;
                        flag = true;
                    }
                    else if (tmp.equals("ay") || tmp.equals("wo")){
                        flag = false;                        
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                else if(tmp.length()==3){
                    if(tmp.equals("aya") && state != 3){
                        tmp = "";
                        state = 3;
                        flag = true;
                    }
                    else if(tmp.equals("woo") && state!=4){
                        tmp = "";
                        state = 4;
                        flag = true;  
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                            
            }
            
            if(!tmp.equals("")){
                flag = false;
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}