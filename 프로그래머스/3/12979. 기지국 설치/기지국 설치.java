// class Solution {
//     public int solution(int n, int[] stations, int w) {
//         int answer = 0;

//         // 아파트의 개수 N
//         // 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations          // 전파의 도달 거리 W
        
//         int[] isEffected = new int[n+1];
        
//         // 초기 세팅
//         for(int station : stations){
            
//             int min = (station - w) >= 1 ? (station-w) : 1;
//             int max = (station + w) <= n ? (station+w) : n;
            
//             for(int i=min ; i<=max; i++){
//                 isEffected[i] = 1;
//             }
            
//         }
        
        
//         // 0인 구간의 길이를 구한다 -> 설치해야하는 갯수를 각각 카운트할 수 있음.
        
//         // 커버 범위 : 2*w+1
        
//         int len = 0;
        
//         for(int i=1; i<=n ;i++){
            
//             if(isEffected[i] == 1 && len > 0){
//                 answer += len%(2*w+1) == 0 ? len/(2*w+1) : len/(2*w+1)+1; 
//                 len = 0;
//             }
//             else if(isEffected[i] == 0){
//                 len++;
//             }
            
            
//         }
        
//         if(len > 0){
//                 answer += len%(2*w+1) == 0 ? len/(2*w+1) : len/(2*w+1)+1; 
//             }
        
        
//         return answer;
//     }
// }


class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 아파트의 개수 N
        // 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations          // 전파의 도달 거리 W
    
        int left = 1;
        int right = -1;
        int len = 0;
        int coverage = 2 * w + 1;

        
        for(int i=0; i<stations.length; i++){
            
            int station = stations[i];
            
            right = station-w-1;
            
            len = right - left + 1;
            
            if(len > 0){
                answer += len % coverage == 0 ? len / coverage : len / coverage + 1;
            }
            left = station + w+1;
            

        }
        
        if(left <= n){
            len = n - left + 1;
                answer += len % coverage == 0 ? len / coverage : len / coverage + 1;
        }
        

        

        
        return answer;
    }
}