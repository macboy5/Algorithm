#include <iostream>
#include <vector>

using namespace std;

void solve(vector<int>&array, int N){
    vector<int> answer(N, 0);

    for(int i=0; i<N; i++){
        int cnt = 0;
        int tmp = array[i];
        for(int j=0; j< N; j++){
            if(cnt == tmp){
                if(answer[j] == 0) {
                    answer[j] = i + 1;
                    break;
                }
                else continue;
            }
            if(answer[j] == 0 ) cnt++;
        }
    }

    for(int i=0; i<N; i++){
        cout << answer[i] << " ";
    }

}

int main(){
    int N;
     cin >> N;

     vector<int> array(N);

     for(int i=0; i<N; i++){
         cin >> array[i];
     }

     solve(array, N);

    return 0;
}