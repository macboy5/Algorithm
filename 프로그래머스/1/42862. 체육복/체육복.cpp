#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;

    vector<int> total(n, 1);
    
    for(int j=0; j<reserve.size(); j++){
        total[reserve[j] - 1] = 2;
    }

    for(int j=0; j<lost.size(); j++){
        if(total[lost[j] - 1] == 2) total[lost[j] - 1] = 1;
        else{
            total[lost[j]-1] = 0;
        }
    }
    
    
    for(int i=0; i<n; i++){
        if(i>=1 && total[i] == 0 && total[i-1] ==2){
            total[i] = 1;
            total[i-1] =1;
        }
        else if(i< n-1 && total[i] == 0 && total[i+1] ==2){
            total[i] = 1;
            total[i+1] = 1;
        }
    }
    
    
    for(int i=0; i<n; i++){
        if(total[i] >= 1) answer++;
    }
    
    
    return answer;
}