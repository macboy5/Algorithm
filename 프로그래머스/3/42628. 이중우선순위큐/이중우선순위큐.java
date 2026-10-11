import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // 최소값이 앞
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 최대값이 앞
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1,o2)->
                                                         {return o2-o1;});
        
        for(String operation : operations){
            char c = operation.charAt(0);
            String tmp = operation.substring(2);
            int num = Integer.parseInt(tmp);
            if(c == 'I'){
                pq.add(num);
                pq2.add(num);
            }
            else if(c == 'D'){
                if(num == 1){ // 최대값 삭제
                    if(!pq.isEmpty()){ 
                        int tmp1 = pq2.poll();
                        pq.remove(tmp1);
                    }
                }
                else if(num == -1){ // 최소값 삭제
                    if(!pq.isEmpty()){
                        int tmp2 = pq.poll();
                        pq2.remove(tmp2);
                    }
                }
            }
        }
        
        if(pq.isEmpty()) {
            answer[0]=0; 
            answer[1]=0;
        }
        else{
            answer[0] = pq2.peek();
            answer[1] = pq.peek();
            
        }
        return answer;
    }
}