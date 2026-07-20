import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        String tmp = "";
        for(int i=0; i<len; i++){
            
            if(arr[i] >= '0' && arr[i]<='9'){
                answer += String.valueOf(arr[i]);
            }
            else{
                tmp += String.valueOf(arr[i]);
            }
            
            if(tmp.equals("zero")){
                answer += "0";
                tmp = "";
            }
            else if(tmp.equals("one")){
                answer += "1";
                tmp = "";
            }
            else if(tmp.equals("two")){
                answer += "2";
                tmp = "";
            }
            else if(tmp.equals("three")){
                answer += "3";
                tmp = "";
            }
            else if(tmp.equals("four")){
                answer += "4";
                tmp = "";
            }
            else if(tmp.equals("five")){
                answer += "5";
                tmp = "";
            }
            else if(tmp.equals("six")){
                answer += "6";
                tmp = "";
            }
            else if(tmp.equals("seven")){
                answer += "7";
                tmp = "";
            }
            else if(tmp.equals("eight")){
                answer += "8";
                tmp = "";
            }
            else if(tmp.equals("nine")){
                answer += "9";
                tmp = "";
            }
            
        }
        
        int result = Integer.parseInt(answer);
        
        return result;
    }
}