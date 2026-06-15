import java.util.*;


class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // n 진법        
        // t 개 말한다
        // m 명이 참여한다
        // p번쨰로 참여한다
        
        // 0 1 2 3 4 5 6 7 8 9 10 ...
        // 0 1 10 11 100 101 110 111 1000 1001 1010
        
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ..
        // 0 1 2 3 4 5 6 7 8 9 A B C D E F 10 11 12 ...
        
        int cnt = 0;    // 말한 숫자의 갯수 
        int cur = -1;    // 현재 숫자
        int idx = 1;    // 현재 인원 번호
        
        Queue<Character> jinsu = new LinkedList<>();
        
        while(cnt < t){
            
            if(jinsu.isEmpty()){
                cur++;
                String changed = Integer.toString(cur, n);
                
                for (char c : changed.toCharArray()) {
                jinsu.add(c);
                }
            }
            
            while(!jinsu.isEmpty() && cnt < t){                
                if(idx == p && idx != m){
                    char c = jinsu.peek();
                    answer += c;
                    cnt++;
                    jinsu.poll();
                    idx++;
                }
                else if(idx == p && idx == m){
                    char c = jinsu.peek();
                    answer += c;
                    cnt++;
                    jinsu.poll();
                    idx = 1;
                }
                else if(idx == m){
                    jinsu.poll();
                    idx = 1;                    
                }
                else{
                    jinsu.poll();
                    idx++;                    
                }
            }
                            

        }
        
        
        return answer.toUpperCase();
    }
    
    
}