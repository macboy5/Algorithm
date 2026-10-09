class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        char[] arr = new char[myString.length()];
        
        int idx = 0;
        for(char c : myString.toCharArray()){
            if(c == 'A') arr[idx] = 'B';
            else if(c == 'B') arr[idx] = 'A';
            else arr[idx] = c;
            idx++;
        }
        
        String tmp = String.valueOf(arr);
        
        
        return tmp.contains(pat) ? 1 : 0;
    }
}