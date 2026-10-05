import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\}\\,\\{");

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        
        Set<Integer> set = new LinkedHashSet<>();
        for (String str : arr) {
            String[] numbers = str.split(",");
            for (String num : numbers) {
                set.add(Integer.parseInt(num));
            }
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}