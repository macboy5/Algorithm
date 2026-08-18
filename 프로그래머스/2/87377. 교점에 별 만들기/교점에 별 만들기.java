import java.util.*;

class Solution {
    class Point{
        private long x;
        private long y;
        
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
       
        List<Point> list = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i=0; i<line.length; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for(int j=i+1; j<line.length; j++){
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                long num1 = b*f - e*d;
                long num2 = e*c - a*f;
                long num3 = a*d - b*c;
                if(num3 == 0) continue;
                
                if(num1 % num3 != 0 || num2 % num3 != 0) continue;
                long x = num1 / num3;
                long y = num2  / num3;
                
                list.add(new Point(x, y));
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for (Point p : list) {
            int nx = (int) (p.x - minX);
            int ny = (int) (maxY - p.y); // Y축 뒤집기
            map[ny][nx] = '*';
        }
        
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }
        
        return answer;
    }
}