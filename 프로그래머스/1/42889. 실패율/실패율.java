import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] stageCnt = new int[N+2];
        
        for(int stage : stages){
            stageCnt[stage]++;
        }
        
        HashMap<Integer, Double> hm = new HashMap<>();
        int totalUsers = stages.length;
        int sum =0;
        
        for(int i=1; i<=N; i++){
            if(totalUsers-sum == 0){
                hm.put(i, 0.0);
            }
            else{
                double rate = (double)stageCnt[i]/(totalUsers-sum);
                hm.put(i, rate);
            }
            sum += stageCnt[i];
        }
        
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(hm.entrySet());
        
        
        entryList.sort((a, b) -> {
            // Value 기준 내림차순 (큰 값이 앞으로)
            int comp = Double.compare(b.getValue(), a.getValue());
            if (comp == 0) {
                // Value가 같다면 Key 기준 오름차순 (작은 번호가 앞으로)
                return Integer.compare(a.getKey(), b.getKey());
            }
            return comp;
        });
        

        answer = new int[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            answer[i] = entryList.get(i).getKey();
        }
        
        
        return answer;
    }
}