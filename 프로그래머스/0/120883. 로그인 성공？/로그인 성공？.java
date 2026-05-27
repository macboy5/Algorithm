class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        String tid = id_pw[0];
        String tpw = id_pw[1];
        
        for(String[] user : db){
            String uid = user[0];
            String upw = user[1];
            
            if(uid.equals(tid)){
                if(upw.equals(tpw)) return "login";
                else return "wrong pw";
            }
            else continue;
            
            
        }
        
        return "fail";
    }
}