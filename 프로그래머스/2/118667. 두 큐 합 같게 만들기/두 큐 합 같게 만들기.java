import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum =0, sum1 = 0, sum2 = 0;
        for(int q : queue1){ 
            sum1 += q;
            q1.offer(q);
        }
        for(int q : queue2){ 
            sum2 += q;
            q2.offer(q);
        }
        
        sum = sum1 + sum2;
        // 합이 홀수일 때 불가능
        if(sum%2 !=0) return -1;
        
        int cnt = 0;
        while(cnt < (queue1.length+queue2.length)*2){
            
            if(sum1 == sum2){
                answer = cnt;
                break;
            }
            
            // q2에서 빼서 q1에 넣는다.
            if(sum1 < sum2 && !q2.isEmpty()){
                int num = q2.peek();
                sum2 -= q2.poll();
                q1.offer(num);
                sum1 += num;
            }
            else if(sum2 < sum1 && !q1.isEmpty()){   
                // q1에서 빼서 q2에 넣는다
                int num = q1.peek();
                sum1 -= q1.poll();
                q2.offer(num);
                sum2 += num; 
            }
            else{ 
                break;
            }
        
            
            cnt++;           

                       
        }
        
        return answer;
    }
}