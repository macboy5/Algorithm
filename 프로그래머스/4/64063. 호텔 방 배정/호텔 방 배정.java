import java.util.*;

class Solution {
    HashMap<Long, Long> hm = new HashMap<>(); // (입력방번호, 다음배정방번호)
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for(int i=0; i<n; i++){
            answer[i] =findRoom(room_number[i]);
        }
        
        return answer;
    }
    
    private long findRoom(long room){
        
        if(!hm.containsKey(room)){ // 최초
            hm.put(room, room+1);
            return room;
        }
        else{ //이비 해당 방이 사용중
            long next = findRoom( hm.get(room) );
            hm.put(room, next);
            return next;
        }
        
    }
    
}