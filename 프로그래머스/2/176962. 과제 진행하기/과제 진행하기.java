import java.util.*;
class Solution {
           
    static class Task{
        private String name;
        private int start;
        private int remainTime;
        
        Task(String[] plan){
            this.name = plan[0];
            this.start = timeToMin(plan[1]);
            this.remainTime = Integer.parseInt(plan[2]);
        }
        
        private void calculate(int time){
            this.remainTime -= time;
        }
        
    }
    
    public String[] solution(String[][] plans) {
        String[] answer =  new String[plans.length];
        List<String> list = new ArrayList<>();
        
        Stack<Task> st = new Stack<>();
    
        List<Task> planList = new ArrayList<>();
        for(String[] plan : plans){
            planList.add(new Task(plan));                          
        }
        
                // 시작시간 오름차순 정렬
        planList.sort((p1,p2)->p1.start-p2.start);
        
                
        for(int i=0; i<planList.size()-1; i++){
            Task now = planList.get(i);
            Task next = planList.get(i+1);
            int curTime = now.start;
            
            // next보다 먼저 끝나는 경우
            // 스택을 돌면서 처리
            if(curTime + now.remainTime <= next.start){
                curTime += now.remainTime;
                int gap = next.start - curTime;
                
                list.add(now.name);
                
                while(!st.isEmpty() && gap > 0){
                    Task top = st.peek();

                    if(gap >= top.remainTime){
                        gap -= top.remainTime;
                        curTime += top.remainTime;
                        list.add(top.name);
                        st.pop();
                    }
                    else{
                        top.calculate(gap);
                        gap = 0;
                    }
                    
                }
                
            }
            else{ // now가 끝나기전에 next가 도달하는 경우
                int gap = next.start - curTime;
                now.calculate(gap);
                st.push(now);
                
            }
            
            
            
        }
        
        list.add(planList.get(planList.size() - 1).name);
        while(!st.isEmpty()){
            list.add(st.pop().name);
        }
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static int timeToMin(String time){
        String[] hm = time.split(":");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        return h*60+m;
    }

}