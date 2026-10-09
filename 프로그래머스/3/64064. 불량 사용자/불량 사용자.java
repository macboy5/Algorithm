import java.util.*;

class Solution {
    
    static String[] userIds;
    static String[] bannedIds;
    static HashSet<HashSet<String>> setList = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        userIds = user_id;
        bannedIds = banned_id;
        
        
        dfs(new HashSet<>(), 0);    
        
        return setList.size();
    }
    
    private static void dfs(HashSet<String> set, int depth){
        if(depth == bannedIds.length){
            setList.add(new HashSet<>(set));
            return;
        }
        
        for(String uId : userIds){
            if(set.contains(uId)) continue;
            
            if( isSame(uId, bannedIds[depth]) ){
                set.add(uId);
                dfs(set, depth+1);
                set.remove(uId);
            }
            
            
        }
        
    }
    
    private static boolean isSame(String uId, String bId){
        if(uId.length() != bId.length()) return false;
        
        for(int i=0; i<uId.length(); i++){
            if(bId.charAt(i) != '*' && uId.charAt(i) != bId.charAt(i)) return false;
        }
        
        return true;        
    }
    
}