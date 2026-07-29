import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = 0;
        while(k>1){
            list.add(k);
            if(k%2==0){
                k/= 2;
            }
            else{
                k *= 3;
                k++;
            }
            n++;
        }
        list.add(1);

       // System.out.println("n :" + n);
        
        int idx = 0;
        for(int[] range : ranges){
            int a = range[0];
            int b = range[1];
            // System.out.println("init a : " + a + "init b : " + b);
            if(b<=0) b = n + range[1];
            // System.out.println("after b : " + b);
            if(a>b) {
                answer[idx] += -1.0;
                // continue;    
            }
            else if(a==b) answer[idx] = 0;
            else answer[idx] = func(a,b, list);
            
            
            // System.out.println("idx : " + idx);            
            idx++;
        }
        
        return answer;
    }
    
    public double func(int a, int b,  ArrayList<Integer> list){
        double result = 0;
        
        // [a,b]의 넓이 return
        
        
        for(int i=a; i<b; i++){
            int y1= list.get(i);
            int y2= list.get(i+1);
            
            // System.out.println("y1 : " + y1 + "y2 : " + y2);
            
            // 사다리꼴 넓이
            result += (double)(y1+y2)/2;
            
        }
        
       // System.out.println("result : " + result);
        
        return result;
    }
}