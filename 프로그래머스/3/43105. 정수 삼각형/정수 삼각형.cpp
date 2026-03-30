#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = -1;
    
    int rows = triangle.size();
    
    vector<vector<int>> dp(rows, vector<int>(rows,0));
        
    dp[0][0] = triangle[0][0];
    
    // k 는 j-1, j
    //dp[i][j] = dp[i-1][k] + triangle[i][j];
    for(int i=1; i<rows; i++){
        
        for(int j=0; j<=i; j++){
            
            int left = j-1;
            int right = j;
            int maxVal = -1;
            
            if(left>=0){
                maxVal = max(maxVal, dp[i-1][left]+triangle[i][j]);    
            }
            if(right<=i){
                maxVal = max(maxVal,dp[i-1][right] + triangle[i][j] );
            }
            
            dp[i][j] = maxVal;
            
        }
    
        }
    
        
    for(int i=0; i<rows; i++){
        answer = max(answer, dp[rows-1][i]);
    }
    
    
    return answer;
}