import java.util.*;
class Solution {
    
    static class MineralCnt{
        private int idx;
        private int diamondCnt;
        private int ironCnt;
        private int stoneCnt;
        
        MineralCnt(int idx, int diamondCnt, int ironCnt, int stoneCnt){
            this.idx = idx;
            this.diamondCnt = diamondCnt;
            this.ironCnt = ironCnt;
            this.stoneCnt = stoneCnt;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int len = minerals.length;
    
        List<MineralCnt> mineralCntList = new ArrayList<>();
        
        int totalPicks = 0;
        for(int pick : picks){
            totalPicks += pick;
        }
        
        int maxMineralLen = Math.min(len, totalPicks * 5);
        
        // 5개씩 잘라서 검사
        for (int i = 0; i < maxMineralLen; i += 5) {
            int diamondCnt = 0;
            int ironCnt = 0;
            int stoneCnt = 0;
            
            for (int j = i; j < i + 5 && j < maxMineralLen; j++) {
                if (minerals[j].equals("diamond")) {
                    diamondCnt++;
                } else if (minerals[j].equals("iron")) {
                    ironCnt++;
                } else if (minerals[j].equals("stone")) {
                    stoneCnt++;
                }
            }
            
            mineralCntList.add(new MineralCnt(i/5, diamondCnt, ironCnt, stoneCnt));
        }
        
        mineralCntList.sort((m1, m2) -> {
                    if (m1.diamondCnt != m2.diamondCnt) {
                        return m2.diamondCnt - m1.diamondCnt;
                    }
                    if (m1.ironCnt != m2.ironCnt) {
                        return m2.ironCnt - m1.ironCnt;
                    }
                    return m2.stoneCnt - m1.stoneCnt;
                });
        
        
        int toolIdx = 0;
        String[] tools = {"dia", "iron" , "stone"};
        
        List<String> assignedTools = new ArrayList<>();
        for(int i=0; i<picks.length; i++){
            while(picks[i]>0 && toolIdx < mineralCntList.size()){
                assignedTools.add(tools[i]);
                picks[i]--;
                toolIdx++;
            }
        }
        
        for(int i=0; i<mineralCntList.size(); i++){
            if(i >= assignedTools.size()) break;
            
            MineralCnt mc = mineralCntList.get(i);
            String tool = assignedTools.get(i);
            
            int startIdx = mc.idx*5;
            for(int j=startIdx ; j<startIdx + 5 && j < maxMineralLen; j++){
                answer += calculate(tool, minerals[j]);
            }
            
        }
        
        return answer;
    }
    
    public int calculate(String tool, String mineral){
        
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