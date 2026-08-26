import java.util.*;

class Solution {
    
    class  Interval{
        private int start;
        private int end;
        
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        List<Interval> list = new ArrayList<>();
        for(int[] target : targets){
            
            int s = target[0];
            int e = target[1];
            
            list.add(new Interval(s, e));           
            
        }       
        
        list.sort( (i1, i2) -> {
                return i1.end - i2.end;

        });      
        
        int nowEnd = -1;
        
        for(int i=0; i<list.size(); i++){
            Interval in = list.get(i);
            
            if(nowEnd <= in.start){
                nowEnd = in.end;
                answer++;
            }
        }
        
        
        
        return answer;
    }
}