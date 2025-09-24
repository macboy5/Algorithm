#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#include <climits>
#include <set>
#include<unordered_map>

using namespace std;



int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    int N, M;
    cin >> N >> M;

    unordered_map<int, string> poketmon1(N);
    unordered_map<string, int> poketmon2(N);

    for(int i=1; i<=N; i++){
        string name;
        cin >> name;
        poketmon1.insert({i, name});
        poketmon2.insert({name, i});


    }

    for(int i=0; i<M; i++){
        string tmp;
        cin >> tmp;

        if(isdigit(tmp[0])){
            cout << poketmon1[stoi(tmp)] << "\n";
        }
        else{
            cout << poketmon2[tmp] << "\n";
        }


    }



    return 0;
}