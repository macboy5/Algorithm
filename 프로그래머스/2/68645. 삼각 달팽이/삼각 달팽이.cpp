#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    
    vector<vector<int>> tmp(n, vector<int>(n,-1));
    
    int cur_row=0, cur_col=0;
    int cnt = 1;
    // n-1 n-4 n-7 ...
    
    for(int j = n-1; j>=0; j-=3){
        if(j!= n-1) cur_row++;
        
        if(j==0) tmp[cur_row][cur_col] = cnt;
        
        for(int i=1; i<=j; i++){
            // dir1
            tmp[cur_row++][cur_col] = cnt++;
        }
        for(int i=1; i<=j; i++){
            // dir 2
            tmp[cur_row][cur_col++] = cnt++;
        }
        for(int i=j; i>=1; i--){
            // dir 3
            tmp[cur_row--][cur_col--] = cnt++;
        }
        cur_row++; 
        cur_col++;
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n ; j++){
            if(tmp[i][j] != -1){
                answer.push_back(tmp[i][j]);
            }
        }
    }
    
    
    return answer;
}