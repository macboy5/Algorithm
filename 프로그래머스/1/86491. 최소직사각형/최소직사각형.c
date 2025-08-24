#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// sizes_rows는 2차원 배열 sizes의 행 길이, sizes_cols는 2차원 배열 sizes의 열 길이입니다.
int solution(int** sizes, size_t sizes_rows, size_t sizes_cols) {
    int answer = 0;
    int w,h;
    int minW=0, minH=0;
    
    for(int i=0; i<sizes_rows; i++){
        
        if(sizes[i][0] >= sizes[i][1]){
            w = sizes[i][0];
            h = sizes[i][1];
        }else{
            w = sizes[i][1];
            h = sizes[i][0];
        }
        
        if(w > minW) minW = w;
        if(h > minH) minH = h;
    }
    
    answer = minW * minH;
    
    return answer;
}