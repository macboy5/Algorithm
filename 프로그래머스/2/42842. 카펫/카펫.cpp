#include <string>
#include <vector>
#include <math.h>

using namespace std;

vector<pair<int,int>> solution(int brown, int yellow) {
    vector<pair<int,int>> answer;
    
    int total = brown + yellow;
    
    vector<int> garo, sero, garo_y, sero_y;    
    
    for(int i=total/2; i>=3; i--){
        if( total % i == 0 && i >= total/i ){
            garo.push_back(i);
            sero.push_back(total/i);
            garo_y.push_back(i-2);
            sero_y.push_back(total/i-2);
        }       
    }
    
    for(int i=0; i<garo.size(); i++){

        if(garo_y[i] * sero_y[i] == yellow && garo[i] * sero[i] == total){
                answer.push_back({garo[i],sero[i]});
                break;
        }

    }
    
    return answer;

}