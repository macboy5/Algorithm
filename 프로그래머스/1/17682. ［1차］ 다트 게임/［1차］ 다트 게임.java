import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        char[] arr = dartResult.toCharArray();
        
        
        String tmp = "";
        int num = 0;
        
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            
            if(c >= '0' && c<='9'){
                tmp += c;
            }
            else if(c == 'S'){
                num = Integer.parseInt(tmp);
                list.add(num);
                tmp = "";
            }
            else if(c == 'D'){
                num = Integer.parseInt(tmp);
                num = num*num;
                list.add(num);
                tmp = "";
            }
            else if(c == 'T'){
                num = Integer.parseInt(tmp);
                num = num*num*num;
                list.add(num);
                tmp = "";
            }
            else if(c == '*'){
                
                int idx = list.size()-1;
           //     System.out.println("before : " + list.get(idx));
                list.set(idx, list.get(idx)*2);
           //     System.out.println("after :" + list.get(idx));
                
                if(idx>=1) list.set(idx-1, list.get(idx-1)*2);
            }
            else if(c == '#'){
                int idx = list.size()-1;
                list.set(idx, list.get(idx)*-1); 
            }
            
        
        }
        

        
        for(int i=0; i<3; i++){
            answer += list.get(i);
        //   System.out.println(list.get(i));
        }
        
        
        return answer;
    }
}