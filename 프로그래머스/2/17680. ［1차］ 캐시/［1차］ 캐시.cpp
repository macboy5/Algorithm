#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;


int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    if(cacheSize == 0){
        return cities.size()*5;
    }
    
    vector<string> v;
    int idx = 0;
    
    
    for(auto city : cities){
            int flag = -1;

            transform(city.begin(), city.end(), city.begin(), ::tolower);
            
            idx = v.size();
        
            for(int i=0; i<idx; i++){
                if(i == cacheSize) break;
                if(v[i] == city ){
                    answer += 1;
                    v.erase(v.begin()+i);
                    v.push_back(city);
                    flag = 1;
                    break;
                }
            }
        
            if(flag == -1){
                answer += 5;
                if(v.size() < cacheSize){
                v.push_back(city);
                }
                else{
                    v.erase(v.begin());
                    v.push_back(city);
                }
            }
            
            
            

    }
    
    
    return answer;
}