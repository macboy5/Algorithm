#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    for(int i=0; i<arr.size(); i++){
        if(answer.empty()) answer.push_back(arr[i]);
        
        if(answer.back() == arr[i]){
            continue;
        }
        else{
            answer.push_back(arr[i]);
        }
    }
    
//     cout << "[";
//     for(int i=0; i<answer.size(); i++){

//         cout << answer[i] ;
//         if( i != answer.size() -1) cout << ",";

//     }
//     cout << "]";

    return answer;
}