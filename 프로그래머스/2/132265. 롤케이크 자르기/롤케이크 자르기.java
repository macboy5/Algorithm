import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int length = topping.length;
        
        Map<Integer, Integer> map1 = new HashMap<>(); 
        Set<Integer> set1 = new HashSet<>(); 
        
        for(int i=0; i<length; i++){
            if(map1.containsKey(topping[i])){
                map1.put(topping[i], map1.get(topping[i])+1);
            }
            else{
                map1.put(topping[i], 1);
            }
        }
        
        for(int i=0; i<length; i++){
            if(map1.get(topping[i]) >=1){
                set1.add(topping[i]);
                map1.put(topping[i], map1.get(topping[i])-1);
            }
            
            
            if(map1.get(topping[i]) == 0){
                map1.remove(topping[i]);
            }      
            
            if(set1.size() == map1.size()) answer++;

        }
        
        return answer;
    }
}