import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        char[][] map = new char[row][col];
        
        for(int i=0; i<row ; i++){
            map[i] = wallpaper[i].toCharArray();
        }
        
        List<Integer> x_list = new ArrayList<>();
        List<Integer> y_list = new ArrayList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == '#'){
                    x_list.add(i);
                    x_list.add(i+1);
                    y_list.add(j);
                    y_list.add(j+1);
                }
            }
        }
        
        Collections.sort(x_list);
        Collections.sort(y_list);
        
        answer[0] = x_list.get(0);
        answer[1] = y_list.get(0);
        answer[2] = x_list.get(x_list.size()-1);
        answer[3] = y_list.get(y_list.size()-1);
        
        return answer;
    }
}