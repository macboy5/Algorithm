import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        double answer = 0;
        
        if( (a== b) && (b==c) &&(c==d)){
            answer = 1111 * a;
        }
        else if( (a==b) && (b==c) && (c!=d) ){
            answer = Math.pow( (10*a+d), 2);
        }
        else if( (a==b) && (b!=c) && (b==d)){
            answer = Math.pow( (10*a+c), 2);
        }
        else if( (a!=b) && (a==c) && (a==d)){
            answer = Math.pow( (10*a+b), 2);
        }
        else if( (a!=b) && (b==c) && (b==d)){
            answer = Math.pow( (10*b+a), 2);
        }
        // a와 b c와d
        else if( (a==b) && (b!=c) && (c==d)){
            answer = (a+c)*Math.abs(a-c);
        }
        // a와 c b와 d
        else if( (a==c) && (b!=c) && (b==d)){
            answer = (a+b)*Math.abs(a-b);
        }
        // a와 d b와 c
        else if( (a==d) && (a!=b) && (b==c)){
            answer = (a+b)*Math.abs(a-b);
        }     
        else if( (a==b) && (b!=c) && (b!=d) && (c!=d) ){
            answer = c*d;
        }
        else if( (a==c) && (b!=c) && (c!=d) && (b!=d) ){
            answer = b*d;
        }
        else if( (a==d) && (a!=c) && (a!=b) && (b!=c) ){
            answer = b*c;
        }
        else if( (b==c) && (b!=a) && (b!=d) && (a!=d) ){
            answer = a*d;
        }
        else if( (b==d) && (b!=a) && (b!=c) && (a!=c) ){
            answer = a*c;
        }
        else if( (c==d) && (c!=a) && (c!=b) && (a!=b) ){
            answer = a*b;
        }
        else if( (a!=b) && (a!=c) && (a!=d) && (b!=c) && (b!=d) && (c!=d)){
            int tmp1 = Math.min(a,b);
            int tmp2 = Math.min(c,d);
            answer = Math.min(tmp1,tmp2);
        }
        
        int real = (int)answer;
        
        return real;
    }
}