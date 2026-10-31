import java.util.*;

class Solution {
    class Student{
        int idx;
        int rank;
        
        Student(int idx, int rank){
            this.idx = idx;
            this.rank = rank;
        }
    }
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Student> list = new ArrayList<>();
        
        for(int i=0 ; i<rank.length; i++){
            if(attendance[i]){
                list.add(new Student(i, rank[i]));
            }    
        }
        
        list.sort( (s1, s2 ) ->{
            return s1.rank - s2.rank;
                  });
        
        int a = list.get(0).idx;
        int b = list.get(1).idx;
        int c = list.get(2).idx;
        
        
        answer = 10000*a + 100*b + c;
        
        return answer;
    }
}