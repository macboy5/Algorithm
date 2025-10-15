#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
#include <unordered_set>

using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    unordered_set <string> memo;
    for(int i=1; i<=N; i++){
        string tmp;
        cin >> tmp;
        memo.insert(tmp);
    }


    for(int i=1; i<=M; i++){
        string tmp;
        cin >> tmp;

        int idx = 0;
        string key = "";

        for(int j=0; j<tmp.length(); j++){
            if(tmp[j] == ','){
                for(int k=idx; k<j; k++){
                    key += tmp[k];
                }
//                cout << key << "\n";
                memo.erase(key);
                idx = j+1;
//                cout << idx << "\n";
                key = "";
            }
            else if(j == tmp.length()-1){
                for(int k=idx; k<=j; k++){
                    key += tmp[k];
                }
//                cout << key << "\n";
                memo.erase(key);
                idx = j+1;
//                cout << idx << "\n";
                key = "";
            }
        }

        cout << memo.size() << "\n";
    }




    return 0;
}