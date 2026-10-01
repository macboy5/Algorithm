import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int gemsLen = gems.length;
        
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems){
            gemSet.add(gem);
        }
        int gemCategoryCnt = gemSet.size();
        int minLength = Integer.MAX_VALUE;
       
        HashMap<String, Integer> hm = new HashMap<>();
        
        int startIdx = 0, endIdx = 0;
        int start = 0, end = 0;
        
        while(end < gemsLen){
            
            // 보석 추가
            hm.put(gems[end], hm.getOrDefault(gems[end] , 0 ) + 1);
            end++;
            
            //만약 모든 종류의 보석을 가지고 있다면 start를 오른쪽으로 옮기면서 검사
            while(hm.size() == gemCategoryCnt){
                
                if(end-start < minLength){
                    minLength = end - start;
                    startIdx = start;
                    endIdx = end;
                }
                
                
                hm.put(gems[start], hm.get(gems[start]) -1);
                
                if(hm.get(gems[start]) == 0){
                    hm.remove(gems[start]);
                }
                
                start++;
                
            }
            
            
            
        }
        
        
                
        return new int[]{startIdx+1, endIdx};
    }
}