//#include <iostream>
//#include <vector>
//#include <algorithm>
//#include <numeric> // std::accumulate 또는 std::fill 사용을 위해
//#include <unordered_set>
//
//using namespace std;
//
//int view(vector <int> &building, int N){
//    int cnt = 0;
//
//    for(int i=2; i<N+2; i++){
//        int cur = building[i];
//        int left = max(building[i-2], building[i-1]);
//        int right = max(building[i+1], building[i+2]);
//
//        if(cur > left && cur > right){
//            int tmp = max(left, right);
//            cnt += (cur - tmp);
//        }
//
//    }
//
//    return cnt;
//
//}
//
//int main() {
//    ios_base::sync_with_stdio(false);
//    cin.tie(NULL);
//
//    for(int j=1 ; j<=10; j++) {
//        int N;
//        cin >> N;
//
//        vector<int> building(N + 4, 0);
//
//        for (int i = 2; i < N + 2; i++) {
//            cin >> building[i];
//        }
//
//        cout <<"#" <<j <<" " << view(building, N) <<"\n";
//
//    }
//
//    return 0;
//}




/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// cin >> a;                            // int 변수 1개 입력받는 예제
// cin >> b >> c;                       // float 변수 2개 입력받는 예제
// cin >> d >> e >> f;                  // double 변수 3개 입력받는 예제
// cin >> g;                            // char 변수 1개 입력받는 예제
// cin >> var;                          // 문자열 1개 입력받는 예제
// cin >> AB;                           // long long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// float b = 1.0, c = 2.0;
// double d = 3.0, e = 0.0; f = 1.0;
// char g = 'b';
// char var[256] = "ABCDEFG";
// long long AB = 12345678901234567L;
// cout << a;                           // int 변수 1개 출력하는 예제
// cout << b << " " << c;               // float 변수 2개 출력하는 예제
// cout << d << " " << e << " " << f;   // double 변수 3개 출력하는 예제
// cout << g;                           // char 변수 1개 출력하는 예제
// cout << var;                         // 문자열 1개 출력하는 예제
// cout << AB;                          // long long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int pari(vector<vector<int>> &array, int N , int M){

    int max = -1;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int sum1 = 0, sum2 =0;
            //정방향
            for(int k=j-M+1; k<=j+M-1; k++){
                if(k>=0 && k<N){
                    sum1 += array[i][k];
                }
            }
            for(int k=i-M+1; k<=i+M-1; k++){
                if(k>=0 && k<N){
                    sum1 += array[k][j];
                }
            }
            sum1 -= array[i][j];
            if(max < sum1) max = sum1;

            //대각선방향
            for(int k=1; k<M; k++){
                if(i-k >=0 && j-k>=0) {
                    sum2 += array[i - k][j - k];
                }
                if(i+k<N && j+k < N){
                    sum2 += array[i+k][j+k];
                }
                if(i-k >=0 && j+k < N){
                    sum2 += array[i-k][j+k];
                }
                if(i+k < N && j-k >=0){
                    sum2 += array[i+k][j-k];
                }
            }
            sum2 += array[i][j];
            if(max < sum2) max = sum2;

        }
    }

    return max;

}

int main(int argc, char** argv)
{
    int test_case;
    int T;
    /*
       아래의 freopen 함수는 input.txt 를 read only 형식으로 연 후,
       앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
       //여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
       freopen 함수를 이용하면 이후 cin 을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
       따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 함수를 사용하셔도 좋습니다.
       freopen 함수를 사용하기 위해서는 #include <cstdio>, 혹은 #include <stdio.h> 가 필요합니다.
       단, 채점을 위해 코드를 제출하실 때에는 반드시 freopen 함수를 지우거나 주석 처리 하셔야 합니다.
    */
    //freopen("input.txt", "r", stdin);
    cin>>T;
    /*
       여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    */
    for(test_case = 1; test_case <= T; ++test_case)
    {

        int N, M;
        cin >> N >> M;
        vector<vector<int>> array(N, vector<int>(N));
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cin >> array[i][j];
            }
        }

        cout <<"#" << test_case <<" " <<pari(array, N, M) << "\n";

    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}