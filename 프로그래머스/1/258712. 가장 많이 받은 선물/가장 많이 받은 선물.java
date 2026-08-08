import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int idx = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for(String friend : friends){
            hm.put(friend, idx++);
        }
        
        int[][] giftCnt = new int[idx][idx];
    
        for(String gift : gifts){
            
            String[] arr = gift.split(" ");
            String from = arr[0];
            String to = arr[1];
            
            giftCnt[hm.get(from)][hm.get(to)]++;
            
        }
        
        //선물지수 구하기
       HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for(int i=0; i<idx; i++){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int j=0; j<idx; j++){
                cnt1 += giftCnt[i][j];
                cnt2 += giftCnt[j][i];
            }
            hm2.put(i, cnt1-cnt2);    
        }
       
        
        for(int i=0; i<idx; i++){
            int cnt = 0;
            for(int j=0; j<idx ; j++){
                
                // (i,j) vs (j,i) 비교
                int tmp1 = giftCnt[i][j];
                int tmp2 = giftCnt[j][i];
                if(tmp1 > tmp2){
                    cnt++;
                }
                else if (tmp1 == tmp2){
                    int jiso1 = hm2.get(i);
                    int jiso2 = hm2.get(j);
                    if(jiso1 > jiso2){
                        cnt++;
                    }
                }
                
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}