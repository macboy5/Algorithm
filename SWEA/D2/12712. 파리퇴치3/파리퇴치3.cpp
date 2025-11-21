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