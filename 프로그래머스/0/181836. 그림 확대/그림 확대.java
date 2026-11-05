
class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = {};

        int col = picture[0].length();
        int row = picture.length;
        
        answer = new String[row*k];
        
        for(int i=0; i<row; i++){
            String s = "";
            for(int j=0; j<col; j++){
                for(int t =0 ; t< k ; t++){
                    s += picture[i].charAt(j);
                }
            }
            for(int t=0; t<k; t++){
                answer[i*k+t] = s;
            }
        }
        
        return answer;
    }
}