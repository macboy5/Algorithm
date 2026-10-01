class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        // diff <= level 내 실력이 퍼즐난도 이상인 경우 : time_cur만큼 소모
        // diff > level 내 실력보다 퍼즐난도가 높을 때 : (diff-level) * (time_cur + time_prev) + time_cur
           
        int round = diffs.length;
        
        int left = 1;
        int right = 100000;
        int mid = (left + right) / 2;
        
        while(left <= right){  // level을 이분 탐색
            
            mid = (left+right)/2;
            
            int level = mid;
            
            long total = 0;
            long time_prev = 0;
            
            
            for(int i=0; i<round; i++){
                
                int diff = diffs[i];        //퍼즐난이도
                int time_cur = times[i];    //각 퍼즐 소요시간            
                
                if(diff <= level){
                    total += time_cur;
                }
                else if(diff > level){
                    total += ((long) (diff-level)*(time_cur + time_prev) + time_cur);
                }
                
                time_prev = time_cur;
                if(total > limit) break;
            }

            
            if(total > limit){
                left = mid + 1;
            }
            else {//시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값
                answer = mid;
                right = mid-1; 
            }     
            
        }
        
        return answer;

    }
}



//         for(int level=1; level<=100000 ; level++){  // level을 이분 탐색?? 최적화??
            
//             long total = 0;
//             long time_prev = 0;
            
            
//             for(int i=0; i<round; i++){
                
//                 int diff = diffs[i];        //퍼즐난이도
//                 int time_cur = times[i]; //각 퍼즐 소요시간            
                
//                 if(diff <= level){
//                     total += time_cur;
//                 }
//                 else if(diff > level){
//                     total += ( (diff-level)*(time_cur + time_prev) + time_cur);
//                 }
                
//                 time_prev = time_cur;
//                 if(total > limit) break;
//             }

            
//             if(total > limit) continue;
//             else {
//                 answer = level; //시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값
//                 break;
//             }     
            
//         }