class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        for(String input : keyinput){
            int x = board[0];
            int y = board[1];
            int curX = answer[0];
            int curY = answer[1];
            
            if(input.equals("left") && curX-1>=x/2*(-1)){
                answer[0] = curX-1;
            }
            if(input.equals("right") && curX+1 <= x/2){
                answer[0] = curX+1;
            }
            if(input.equals("up") && curY+1 <= y/2){
                answer[1] = curY+1;
            }
            if(input.equals("down") && curY-1 >= y/2*(-1)){
                answer[1] = curY-1;
            }
        }
        
        
        return answer;
    }
}