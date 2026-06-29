import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        // 기존 선분들의 기울기를 순서대로 저장할 리스트 (총 6개)
        List<String> slopes = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            for(int j=i+1; j<4; j++){
                int x1 = dots[i][0];
                int y1 = dots[i][1];
                int x2 = dots[j][0];
                int y2 = dots[j][1];
                
                int xDiff = x2-x1;
                int yDiff = y2-y1;
                
                int common = gcd(Math.abs(xDiff), Math.abs(yDiff));
                
                xDiff/= common;
                yDiff/= common;
                
                if(xDiff < 0 ){
                    xDiff = -xDiff;
                    yDiff = -yDiff;
                }
                
                String tmp = yDiff + "/" + xDiff;
                slopes.add(tmp); 
            }
        }

        // 2. 이중 for문이 돌 때 slopes에 담기는 순서는 고정되어 있습니다.
        // index 0: (0,1) 선분  <--->  index 5: (2,3) 선분
        // index 1: (0,2) 선분  <--->  index 4: (1,3) 선분
        // index 2: (0,3) 선분  <--->  index 3: (1,2) 선분
        
        // 3. 점을 공유하지 않는 세 쌍의 대변(상대선) 기울기가 같은지 각각 비교합니다.
        if (slopes.get(0).equals(slopes.get(5)) || 
            slopes.get(1).equals(slopes.get(4)) || 
            slopes.get(2).equals(slopes.get(3))) {
            answer = 1;
        }
        
        return answer;
    }
    
    int gcd(int a, int b){
        while(b!=0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}