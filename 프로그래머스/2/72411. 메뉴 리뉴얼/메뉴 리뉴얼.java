import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // course의 길이만큼 HashMap을 생성
        List<Map<String, Integer>> list = new ArrayList<>();
        for(int i = 0; i < course.length; i++){
            list.add(new HashMap<>());
        }
        
        for(int i = 0; i < course.length; i++){
            int n = course[i];
            
            for(int j = 0; j < orders.length; j++){
                char[] chars = orders[j].toCharArray();
                Arrays.sort(chars); // 알파벳 순 정렬 필수
                
                addCourse(list.get(i), chars, "", n, 0);
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        for(Map<String, Integer> map : list){
            if(map.size() > 0){
                int max = -1;
                
                // 최소 2번 이상 주문된 조합 중 가장 많이 주문된 횟수 찾기
                for(String key : map.keySet()){
                    if(map.get(key) > 1){
                        max = Math.max(max, map.get(key));
                    }
                }
                
                // 가장 많이 주문된 횟수와 일치하는 조합만 결과에 추가
                for(String key : map.keySet()){
                    if(max == map.get(key)){
                        answer.add(key);
                    }
                }
            }
        }
        
        // 결과 정렬 (사전 순)
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    public void addCourse(Map<String, Integer> map, char[] arr, String str, int n, int pos){
        if(str.length() == n){
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for(int i = pos; i < arr.length; i++){
            addCourse(map, arr, str + arr[i], n, i + 1);
        }
    }
}