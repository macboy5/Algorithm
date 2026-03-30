#include <iostream>
#include <vector>
using namespace std;
#include <algorithm>

int solution(vector<vector<int> > land)
{
    int answer = -1;

    int rows = land.size();
    int cols = land[0].size();
    
    
    vector<vector<int>> dp(rows, vector<int>(cols, 0));
    
    for(int i=0; i<rows; i++){
        
        for(int j=0; j<cols; j++){
            
            if(i==0){
                dp[i][j] = land[i][j];
            }
            else{
                int maxVal = -1;
                for(int k=0; k<cols; k++){
                    if(k != j){
                    int tmp = dp[i-1][k] +land[i][j];
                    maxVal = max(tmp, maxVal);
                    }
                }
                dp[i][j] = maxVal;
            }
            
        }
        
        
    }
    
    
    for(int i=0; i<cols; i++){
       answer = max(answer, dp[rows-1][i]);
    }
    
    
    return answer;
}