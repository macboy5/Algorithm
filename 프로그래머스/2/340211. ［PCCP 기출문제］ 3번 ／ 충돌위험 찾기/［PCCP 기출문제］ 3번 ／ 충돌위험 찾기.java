import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotCnt = routes.length; 
        
        // 각 로봇의 시간별 위치를 저장할 리스트 배열
        List<int[]>[] robotList = new ArrayList[robotCnt];
        for(int i = 0; i < robotCnt; i++) {
            robotList[i] = new ArrayList<>();
        }
        
        int maxLen = 0; 
        
        // 각 로봇별로 이동 경로 생성
        for(int i = 0; i < robotCnt; i++) {
            int[] route = routes[i];
            
            // 첫 번째 시작점 위치 설정
            int startPoint = route[0];
            int curR = points[startPoint - 1][0];
            int curC = points[startPoint - 1][1];
            robotList[i].add(new int[]{curR, curC});
            
            // 경유지 순서대로 이동
            for(int j = 0; j < route.length - 1; j++) {
                int nextPoint = route[j + 1];
                int toR = points[nextPoint - 1][0];
                int toC = points[nextPoint - 1][1];
                
                // 1. r 좌표 먼저 이동
                while(curR != toR) {
                    if(curR > toR) {
                        curR--;
                    } else {
                        curR++;
                    }
                    robotList[i].add(new int[]{curR, curC});
                }
                
                // 2. c 좌표 이동
                while(curC != toC) {
                    if(curC > toC) {
                        curC--;
                    } else {
                        curC++;
                    }
                    robotList[i].add(new int[]{curR, curC});
                }
            }
            maxLen = Math.max(maxLen, robotList[i].size());
        }
        
        // 시간(초)별로 로봇들의 위치를 확인하며 충돌 횟수 계산
        for(int t = 0; t < maxLen; t++) {
            HashMap<String, Integer> hm = new HashMap<>();
            
            for(int i = 0; i < robotCnt; i++) {
                List<int[]> path = robotList[i];
                
                // 아직 목적지에 도착하지 않아 경로가 남아있는 로봇만 좌표 카운트
                if(t < path.size()) {
                    int[] pos = path.get(t);
                    String key = pos[0] + "," + pos[1];
                    hm.put(key, hm.getOrDefault(key, 0) + 1);
                }
            }
            
            // 해당 시간에 2대 이상 모인 위치가 있다면 위험 상황 1회 카운트
            for(String key : hm.keySet()) {
                int count = hm.get(key);
                if(count > 1) {
                    answer++; 
                }
            }
        }
        
        return answer;
    }
}