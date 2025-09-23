#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <climits>
#include <set>
#include<unordered_map>

using namespace std;

void solution(vector<int> &card, vector<int> &given){

    unordered_map<int, int> map;

    // 각 숫자의 개수를 정확하게 세는 로직으로 수정
    for(int num : card){
        map[num]++;
    }

    // 각 숫자의 개수를 출력하는 로직으로 수정
    for(int num : given){
        cout << map[num] << " ";
    }
}

int main() {

    int N;
    cin >> N;

    vector<int> card(N);
    for(int i=0; i<N; i++){
        cin >> card[i];
    }

    int M;
    cin >> M;
    vector<int> given(M);
    for(int i=0; i<M; i++){
        cin >> given[i];
    }

    solution(card, given);

    return 0;
}