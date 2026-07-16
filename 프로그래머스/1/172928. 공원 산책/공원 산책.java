class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int row = park.length;
        int col = park[0].length();
        char map[][] = new char[row][col];
        
        int curX = 0;
        int curY = 0;
        
        for(int i=0; i<row; i++){
            String tmp = park[i];
            for(int j=0; j<col; j++){
                char c = tmp.charAt(j);
                map[i][j] = c;
                if(c == 'S'){
                    curX = i;
                    curY = j;
                }
            }
        }

        //        System.out.println("X : " + curX + "Y : "+ curY);
        
        // for(int i=0; i<row; i++){
        //     for(int j=0; j<col; j++){
        //         System.out.print(map[i][j]);              
        //     }
        //     System.out.println();
        // }
        

        
        for(String route : routes){
            String dir = route.substring(0,1);
            int dis = Integer.parseInt(route.substring(2));

            int newX = curX;
            int newY = curY;
            
            boolean flag = false;
            
            switch(dir){
                case "N" :  
                    for(int i=1; i<= dis; i++){
                        newX--;
                        if( newX >=0 && newX <row && map[newX][newY] == 'O') continue;
                        else if(newX >=0 && newX <row && map[newX][newY] == 'X' || newX < 0){
                            flag = true;
                            break;
                        }
                    }

                    
                    break;
                case "S" :
                    for(int i=1; i<= dis; i++){
                        newX++;

                        if( newX >=0 && newX <row && map[newX][newY]  == 'O') continue;
                        else if( newX >=0 && newX <row && map[newX][newY] == 'X' || newX >= row){
                            flag = true; 
                            break;
                        }
                    }

                    break;
                case "W" :
                   for(int i=1; i<= dis; i++){
                        newY--;
                        if( newY >=0 && newY < col && map[newX][newY] == 'O') continue;
                        else if( newY >=0 && newY < col && map[newX][newY] == 'X' || newY <0){
                            flag = true; 
                            break;
                        }
                    }
                    break;
                case "E" :
                    for(int i=1; i<= dis; i++){
                        newY++;
                        if( newY >=0 && newY < col && map[newX][newY]  == 'O') continue;
                        else if( newY >=0 && newY < col && map[newX][newY] == 'X' || newY >= col){
                            flag = true; 
                            break;
                        }
                    }

                    break;
            }
            
            if(!flag){
                        curX = newX;
                        curY = newY;
                    }
        
        }

        
        
        
        return new int[] {curX, curY};
    }
}