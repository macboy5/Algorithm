#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

void solution(vector<int> &natural, vector<int> &given, int N , int M){

    for(int i=0;i<M; i++){
        int target = given[i];
        bool isFound = binary_search(natural.begin(), natural.end(), target);
        if(isFound) cout << 1 << '\n';
        else cout << 0 << '\n';
    }

}


int main() {

    int N;
    cin >> N;
    vector<int> natural(N);

    for(int i=0; i<N; i++){
        cin >> natural[i];
    }
    sort(natural.begin(), natural.end());

    int M;
    cin >> M;
    vector<int> given(M);
    for(int i=0; i<M; i++){
        cin >> given[i];
    }

    solution(natural, given, N ,M);

    return 0;
}