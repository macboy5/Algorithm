import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        char[] arr_x = X.toCharArray();
        char[] arr_y = Y.toCharArray();

        
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        for(char c : arr_x){
            hm1.put(c, hm1.getOrDefault(c, 0)+1);
        }
        for(char c : arr_y){
            hm2.put(c, hm2.getOrDefault(c, 0)+1);
        }
        
        List<Character> list = new ArrayList<>();
        
        for(char i = '0'; i<= '9'; i++){
            
            int value1 = hm1.getOrDefault(i ,0);
            int value2 = hm2.getOrDefault(i, 0);
            
            int min = value1>value2 ? value2 : value1;
            
            if(min > 0){
                for(int j=0; j<min; j++){
                    list.add(i);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, Collections.reverseOrder());
        for(char c : list) {
            sb.append(c);
        }

        String tmp = sb.toString();

        if(tmp.equals("")) return "-1";
        if(tmp.charAt(0) == '0') return "0";

        return tmp;
    }
}