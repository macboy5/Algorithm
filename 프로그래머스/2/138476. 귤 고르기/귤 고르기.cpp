#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

bool compare(pair<int,int> &a, pair<int,int> &b){
    return a.second>b.second ? true : false;    
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    unordered_map<int, int> counts;
    
    for(int size : tangerine){
        counts[size]++;
    }
    
    vector<pair<int, int>> sorted_counts(counts.begin(), counts.end());
    
    sort(sorted_counts.begin(), sorted_counts.end(), compare);

    int sum = 0;
    for(auto const &p : sorted_counts){
        sum += p.second;
        answer++;
        
        if(sum >= k) break;

    }
    
    return answer;
}