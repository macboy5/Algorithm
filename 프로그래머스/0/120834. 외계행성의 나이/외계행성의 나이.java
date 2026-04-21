class Solution {
    public String solution(int age) {
        String answer = "";
        
        String num = Integer.toString(age);
        char c;
        
        for(int i=0; i<num.length(); i++){
            c = num.charAt(i);
            if(c=='0') answer += "a";
            if(c=='1') answer += "b";
            if(c=='2') answer += "c";
            if(c=='3') answer += "d";
            if(c=='4') answer += "e";
            if(c=='5') answer += "f";
            if(c=='6') answer += "g";
            if(c=='7') answer += "h";
            if(c=='8') answer += "i";
            if(c=='9') answer += "j";
            
        }
        
        return answer;
    }
}