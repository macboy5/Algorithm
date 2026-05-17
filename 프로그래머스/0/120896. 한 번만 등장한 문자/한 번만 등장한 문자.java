import java.util.*;

class Solution {
    public String solution(String s) {

        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        
        StringBuilder sb = new StringBuilder();
        for (char c : m.keySet()) {
            if (m.get(c) == 1) {
                sb.append(c);
            }
        }


        char[] result = sb.toString().toCharArray();
        Arrays.sort(result);

        return new String(result);
    }
}