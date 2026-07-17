import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Arrays.sort(numbers);
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<numbers.length; i++){
            int num1 = numbers[i];
            for(int j=i+1; j<numbers.length; j++){
                int num2 = numbers[j];
                
                int num = num1 + num2;
                set.add(num);
                
            }
        }
        
        int hap = numbers[numbers.length-2]+numbers[numbers.length-1];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<=hap ; i++){
            if(set.contains(i)){
                list.add(i);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}