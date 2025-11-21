#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

// N x N 배열을 90도 회전시키는 함수
// source: 회전할 원본 배열
// N: 배열 크기
vector<vector<int>> rotate_90(const vector<vector<int>>& source, int N) {
    vector<vector<int>> rotated(N, vector<int>(N));
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            // (i, j)의 원소가 회전 후 (j, N-1-i)로 이동
            rotated[j][N - 1 - i] = source[i][j];
        }
    }
    return rotated;
}

void func(const vector<vector<int>>& original, int N){

    // 90도 회전
    vector<vector<int>> rot_90 = rotate_90(original, N);
    
    // 180도 회전 = 90도 회전 결과를 다시 90도 회전
    vector<vector<int>> rot_180 = rotate_90(rot_90, N);

    // 270도 회전 = 180도 회전 결과를 다시 90도 회전
    vector<vector<int>> rot_270 = rotate_90(rot_180, N);
    
    for(int i = 0; i < N; i++){
        // 90도 회전 결과 출력
        for(int j = 0; j < N; j++){
            cout << rot_90[i][j];
        }
        cout << " ";

        // 180도 회전 결과 출력
        for(int j = 0; j < N; j++){
            cout << rot_180[i][j];
        }
        cout << " ";

        // 270도 회전 결과 출력
        for(int j = 0; j < N; j++){
            cout << rot_270[i][j];
        }
        cout << "\n";
    }
}

int main(int argc, char** argv)
{
    // 입출력 최적화
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int T;
    cin>>T;
    
    for(int test_case = 1; test_case <= T; ++test_case)
    {
        int N;
        cin >> N;
        vector<vector<int>>array(N, vector<int>(N));
        
        // 원본 배열 입력
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cin >> array[i][j];
            }
        }

        cout<<"#"<<test_case<<"\n";
        // 원본 배열을 const로 전달하여 func 내부에서 변경하지 않도록 함
        func(array, N); 
    }
    return 0;
}