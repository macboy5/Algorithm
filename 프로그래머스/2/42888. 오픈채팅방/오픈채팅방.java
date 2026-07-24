import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        String[] answer = {};
        
        HashMap<String, String> uidNick = new HashMap<>();
        ArrayList<String> idxState = new ArrayList<>();
        ArrayList<String> sequence = new ArrayList<>();
        
        ArrayList<String> list = new ArrayList<>();
        
        int idx = 0;
        
        for(String record : records){
            
            String[] arr = record.split(" ");

            String state = arr[0];
            String uid = arr[1];           
            
            
            if(state.equals("Enter")){
                idxState.add("E");
                idx++;
                String nickname = arr[2];
                uidNick.put(uid, nickname);
            }
            else if(state.equals("Leave")){
                idxState.add("L");
                idx++;
            }
            else if(state.equals("Change")){
                idxState.add("C");
                String nickname = arr[2];
                uidNick.put(uid, nickname);
            }

           sequence.add(uid);
        
        }      
        
        String tmp = "";
        int cnt = 0;
        
        for(int i=0; i<records.length; i++){                
            tmp = "";
            
            String curUid = sequence.get(i);
            String curNickname = uidNick.get(curUid);
            String curState = idxState.get(i);

            if(curState.equals("C")) continue;
            else cnt++;
            
            tmp += curNickname;
            tmp += "님이 ";
            
            if(curState.equals("E")){
                tmp += "들어왔습니다.";
            }
            else if(curState.equals("L")){
                tmp += "나갔습니다.";
            }         
            
            
            list.add(tmp);
            
        }   
        
        answer = new String[cnt];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}