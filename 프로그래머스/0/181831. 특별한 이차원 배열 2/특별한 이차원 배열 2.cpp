#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> arr) {
    int answer = 1;
    
    int row = arr.size();
    int col = arr[0].size();
    
    
    for(int i=0; i<row ; i++){
        for(int j=0; j<col; j++){
            if(arr[i][j] != arr[j][i]){
                answer = 0;
                break;

                                      }
            else continue;
        }
    }
    
    
    return answer;
}