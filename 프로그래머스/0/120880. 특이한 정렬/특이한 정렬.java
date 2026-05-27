import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Tmp> list = new ArrayList<>();
        for(int num : numlist){
            list.add(new Tmp(num, n));
        }
        
        Collections.sort(list);
        
        int[] answer = new int[numlist.length];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).num;
        }
        
        
        return answer;
    }
    
    class Tmp implements Comparable<Tmp>{
        int num;
        int diff;
        
        Tmp(int num, int n){
            this.num = num;
            this.diff = Math.abs(num-n);
        }
        
        @Override
        public int compareTo(Tmp o){
            if(this.diff != o.diff){
                return this.diff-o.diff;
            }
            else return o.num-this.num;
        }
        
    }
    
}