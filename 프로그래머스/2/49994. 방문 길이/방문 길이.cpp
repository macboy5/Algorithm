#include <string>
using namespace std;

int sero[11][11];
int garo[11][11];   
int curX = 0, curY=0;
int answer = 0;

void func(char type){
    int destX, destY;
    
    
    switch(type){
        case 'U' :
            destX = curX+5;
            destY = curY+5;
            curY++;
            
            if(curY > 5) {
                curY--;
                break;
            }
            
            if(sero[destX][destY] == 0){
                sero[destX][destY]=1;
                answer++;
            }
            break;
        case 'D' :
            destX = curX+5;
            destY = curY+4;
            curY--;
            
            if(curY < -5) {
                curY++;
                break;
            }
            
            if(sero[destX][destY] == 0){
                sero[destX][destY]=1;
                answer++;
            }
            break;
        case 'R' :
            destX = curX+5;
            destY = curY+5;
            curX++;
            
            if(curX > 5) {
                curX--;
                break;
            }
            
            if(garo[destX][destY] == 0){
                garo[destX][destY]=1;
                answer++;
            }
            break;
        case 'L' :
            destX = curX+4;
            destY = curY+5;
            curX--;
            
            if(curX < -5) {
                curX++;
                break;
            }
            
            if(garo[destX][destY] == 0){
                garo[destX][destY]=1;
                answer++;
            }
            break;
            
        default : 
            break;
}
    
    
}

int solution(string dirs) {
    
    int dirs_length = dirs.length();

    for(int i=0; i<dirs_length; i++){
        char c = dirs[i];
        
        if(c == 'U') func('U');
        if(c == 'D') func('D');
        if(c == 'R') func('R');
        if(c == 'L') func('L');
        
    }
    
    return answer;
}