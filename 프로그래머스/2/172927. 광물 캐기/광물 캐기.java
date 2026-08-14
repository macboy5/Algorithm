import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int len = minerals.length;
        
        boolean diamondExists = false;
        boolean ironExists = false;
        boolean stoneExists = false;
        
        List<String> toolList = new ArrayList<>();
        int maxIdx = -1;
        if(len%5 ==0 ) maxIdx = len/5;
        else maxIdx = len/5+1;
        
        // 5개씩 잘라서 검사
        for(int i=0; i< maxIdx ; i++){
            
            for(int j=0; j<5; j++){
                int idx = i*5 + j;
                if(idx < len){
                    if(minerals[idx].equals("diamond")){
                        diamondExists = true;
                    }
                    else if(minerals[idx].equals("iron")){
                        ironExists = true;
                    }
                    else if(minerals[idx].equals("stone")){
                        stoneExists = true;
                    }
                }
            }
            
            if(diamondExists && picks[0] > 0){
                picks[0]--;
                toolList.add("dia");
            }
            else if(!diamondExists && ironExists){
                if(picks[1]>0){
                    picks[1]--;
                    toolList.add("iron");
                }
                else if(picks[2]>0){
                    picks[2]--;
                    toolList.add("stone");                    
                }
            }
            else if(!diamondExists && !ironExists && stoneExists){
                if(picks[2]>0){
                    picks[2]--;
                    toolList.add("stone");
                }
            }
        
        }
        
        int cnt = 0;
        int toolIdx = 0;
        for(String mineral : minerals){

                String tool = toolList.get(toolIdx);
                answer += calculate(tool, mineral);
                cnt++;

            if(cnt == 5) {
                cnt = 0;
                toolIdx++;
            }
        }
        
        return answer;
    }
    
    int calculate(String tool, String mineral){
        
        if(tool.equals("dia")) return 1;
        else if(tool.equals("iron")){
            if(mineral.equals("diamond")) return 5;
            else return 1;
        }
        else if(tool.equals("stone")){
            if(mineral.equals("diamond")) return 25;
            else if(mineral.equals("iron")) return 5;
            else return 1;
        }
        
        return 0;
    }
    
}