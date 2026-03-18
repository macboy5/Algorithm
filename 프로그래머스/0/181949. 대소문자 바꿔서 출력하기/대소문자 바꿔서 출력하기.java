import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String tmp = "";
        
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            if(c>= 'A' && c <= 'Z'){
                tmp += Character.toLowerCase(c);
            }

            if(c >= 'a' && c <= 'z'){
                tmp += Character.toUpperCase(c);
            }
        }
        
        System.out.println(tmp);
    }
}