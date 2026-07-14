import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        List<String> list = new ArrayList<>();
        
        int flag = -1;
        int idx = -1;
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                flag = 1;
                idx = i;
                break;
            }
            else if(str_list[i].equals("r")){
                flag = 2;
                idx = i;
                break;
            }
        }
        
        
        if(flag == 1){
            for(int i=0; i<idx; i++){
                list.add(str_list[i]);
            }
        }
        else if(flag == 2){
            for(int i=idx+1; i<str_list.length ; i++){
                list.add(str_list[i]);
            }
        }
        
        answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
        
    }
}