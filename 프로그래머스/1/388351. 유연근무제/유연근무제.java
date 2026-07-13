class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        //1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5                        는 금요일, 6은 토요일, 7은 일요일
        
        int[] startdays = new int[7];
        for(int i=0; i<7; i++){
            startdays[i] = startday% 7;
            startday++;
        }
        
        int[] safeTimes = new int[schedules.length];
        int idx = 0;
        for(int schedule : schedules){
            
            int hour = schedule/100;
            int min = schedule%100;
            min += 10;
            if(min >=60){
                hour++;
                min -= 60;
            }
            
            if(hour==24){
                hour = 0;
            }
            int safeTime = hour*100+min;
            safeTimes[idx++] = safeTime;
        }
     
            idx=0;
            for(int[] timelog : timelogs){
                int cnt = 0;  
                for(int i=0; i<7; i++){
                    if( timelog[i] <= safeTimes[idx]
                       && startdays[i] <=5 && startdays[i]>=1)                      {
                        cnt++;
                    }
                }
                           
            if(cnt == 5) answer++;
            idx++;
            }

            
            
        
        
        
        
        return answer;
    }
}