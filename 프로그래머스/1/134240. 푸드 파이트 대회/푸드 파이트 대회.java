class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++){
            int eat = food[i]/2;
            for(int j=1; j<=eat ; j++){
            answer += String.valueOf(i);
            }
        }
        answer += "0";
        
        for(int i=food.length-1; i>=1; i--){
            int eat = food[i]/2;
            for(int j=1; j<=eat ; j++){
            answer += String.valueOf(i);
            }
            }
                   
        return answer;
    }
}