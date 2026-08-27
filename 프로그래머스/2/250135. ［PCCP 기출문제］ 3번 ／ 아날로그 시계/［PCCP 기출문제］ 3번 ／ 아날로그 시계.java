class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        //         초침이 시계 한 바퀴를 도는 시간은 60초
        // 분침이 시계 한 바퀴를 도는 시간은 60분 -> 3,600초 
        // 시침이 시계 한 바퀴를 도는 시간은 12시간 -> 43,200초
        
        // 분침이 한 바퀴 돌 동안 초침은 60-1 번 알람 -> 3600/59 마다
        // 시침이 한바퀴 돌 동안 초침은 720-1번 알람 -> 43200/719 마다
        
        
        int startSec = parseToSec(h1, m1, s1);
        int endSec = parseToSec(h2, m2, s2);
        
        answer = countAlarms(endSec) - countAlarms(startSec);
        if(alarmNow(startSec)) answer++;
        
        return answer;
    }
    
    int parseToSec(int h, int m, int s){
        return s + 60 * m + 60 * 60 * h;
    }
    
    int countAlarms(int seconds){
        int cnt = 0;
        cnt += seconds *59 / 3600;
        cnt += seconds * 719 /43200;
        
        if(seconds >= 60*60*12) cnt-= 2;
        else cnt--;
        
        return cnt;
    }
    
    private boolean alarmNow(int seconds) {
    return seconds * 59 / 3600 == 0 || seconds * 719 % 43200 == 0;
}
    
}