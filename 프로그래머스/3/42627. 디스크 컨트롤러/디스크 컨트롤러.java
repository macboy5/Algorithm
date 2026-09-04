import java.util.*;

class Solution {
    
    class Job{
        private int idx; //작업번호
        private int s; // 작업 요청 시점
        private int l; // 작업 소요 시간
        
        Job(int idx, int s, int l){
            this.idx = idx;
            this.s = s;
            this.l = l;
        }
        
        Job(int[] job){
            this.idx = job[0];
            this.s = job[1];
            this.l = job[2];
        }
    }
    
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업 시작 시점에서 대기 큐 검사 : 작업의 소요시간 l 이 짧은 것, 작업의 요청 시각 s 이 빠른 것, 작업의 번호 idx가 작은 것 순
                
        // jobs[i]는 i번 작업에 대한 정보이고 [s(작업요청시점), l(작업 소요시간)] 형태
    
        List<int[]> jobList = new ArrayList<>();
        
        for(int i= 0; i<jobs.length; i++){
            jobList.add(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        jobList.sort((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int idx = 0;
        int endTime = 0;
        int count = 0;
        
        // 대기 큐
        PriorityQueue<Job> pq = new PriorityQueue<Job>( (j1, j2)->{
            if(j1.l == j2.l){
                if(j1.s == j2.s){
                    return j1.idx - j2.idx;
                }
                else return j1.s - j2.s;
            }
            return j1.l - j2.l;
            
        });
        
        // 작업 큐
        Queue<Job> q = new LinkedList<>();
        
           
        while(count < jobs.length){
                       
            // 1. 현재 시간(time) 이하에 요청된 작업들을 대기 큐 삽입
            while(idx < jobs.length){
                int[] job = jobList.get(idx);
                if(job[1] <= time){
                    pq.add(new Job(job));
                    idx++;
                }
                else break;
            }

            
            // 2. 현재 진행 중이던 작업이 끝나는 시점이라면
            if(endTime == time){
                // 직전까지 실행 중이던 작업 처리 완료
                if(!q.isEmpty()){
                    Job curJob = q.poll();     
                    answer += (time - curJob.s);
                    // System.out.println(time-curJob.s);
                    count++;
                }
                // + 대기큐에서 꺼내고 endTime update
                if(!pq.isEmpty()){
                    Job nextJob = pq.poll();
                    q.add(nextJob);
                    endTime = time + nextJob.l;
                }
            }
            
            if(q.isEmpty() && !pq.isEmpty()){
                Job nextJob = pq.poll();
                q.add(nextJob);
                endTime = time + nextJob.l;
            }            
            
            if(q.isEmpty() && pq.isEmpty() && idx<jobs.length){
                time = jobList.get(idx)[1];
                continue;
            }
            
            time++;
            
        }
        
        
        // 모든 요청 작업의 반환 시간의 평균의 정수부분을 return
        return answer/jobs.length;
    }
}