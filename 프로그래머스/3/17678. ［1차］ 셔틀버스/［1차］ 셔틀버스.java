import java.util.*;

class Solution {
    public static List<Integer> minTable;
    public static List<Integer> arrivalTime;
    
    class Min{
        int minute;
        boolean isUsed = false;
        
        Min(int minute){
            this.minute = minute;
        }
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // 셔틀은 09:00부터 n회 운행 t분 간격으로 도착 m명씩 탑승 가능
        // timetable : 하루 동안 콘을 제외한 크루가 대기열에 도착하는 시각
        
        // 같은 시각에 도착하더라도 대기줄의 맨 뒤에 선다. 
        // 23:59에 종료 -> 23:58까지 탑승 가능
        
        //0. 셔틀 도착 시각 배열 
        arrivalTime = new ArrayList<>();
        int init = 540;
        
        for(int i=0; i<n; i++){
            arrivalTime.add(init + t*i); 
        }
        
        // 1. timetable을 min으로 변환
        convertTime(timetable);
        
        // 2. min을 오름차순 정렬
        Collections.sort(minTable);
        
        List<Min> minList = new ArrayList<>();
        for(int min : minTable){
            minList.add( new Min(min));
        }
        
        // 3. 마지막으로 도착할 수 있는 min찾기
        
        // minTable과 arrivalTime 비교
        
        int result = 540;

        int index = 0;
        for(int j = 0; j < arrivalTime.size(); j++){
            int arrival = arrivalTime.get(j);

            int cnt = 0;
            for(int i = index; i < minList.size(); i++){
                int min = minList.get(i).minute;
                boolean isUsed = minList.get(i).isUsed;
                if(min <= arrival && !isUsed ){
                    cnt++;
                }
            }

            int tmp = 0;
            int standard = Math.min(cnt, m); 
            for(int i = index; i < minList.size(); i++){
                Min min = minList.get(i);
                if( !min.isUsed && tmp < standard ){
                    min.isUsed = true;
                    tmp++;
                }
            }

            // 마지막 버스 차례일 때 콘이 탈 수 있는 가장 늦은 시각 계산
            if(j == arrivalTime.size() - 1){
                if(cnt < m){
                    result = arrival; // 자리가 남으면 버스 도착 시각에 탑승
                } else {
                    // 꽉 찼다면 이번 버스에 마지막으로 탄 사람보다 1분 빨리 도착
                    result = minList.get(index + tmp - 1).minute - 1;
                }
            }

            index += tmp;



                }       

        
        // 4. answer 형태로 변환
        int hh = result/60;
        if(hh<10) answer += "0"; 
        answer += String.valueOf(hh);
        
        answer += ":";
        
        int mm = result%60;
        if(mm<10) answer += "0";
        answer += String.valueOf(mm);
        
        // 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각
        return answer;
    }
    
    void convertTime(String[] timetable){
    
        int length = timetable.length;
        minTable = new ArrayList<>();
        
        int idx=0;
        
        for(String time : timetable){
            String[ ] tmp = time.split(":");
            
            int min = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            minTable.add(min);
            idx++;
        }      
    }
    
}