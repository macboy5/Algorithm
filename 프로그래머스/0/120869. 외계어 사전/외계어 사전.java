class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for(String d : dic){
            
            int flag = -1;
            for(int i=0; i<spell.length; i++){
                String s = spell[i];
                if(d.contains(s)) flag = 1;
                else {
                    flag = -1;
                    break;
                }
                if(flag == 1 && i == spell.length-1) answer = 1;
            }
            
        }
        
        return answer;
    }
}