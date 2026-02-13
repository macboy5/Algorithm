#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int N;
char board[1001][1001];

int head_x, head_y, heart_x, heart_y, leg_start_x;
int left_arm=0, right_arm=0, waist=0, left_leg=0, right_leg=0;

void find_head();
void find_heart();
void arm_length();
void waist_length();
void leg_length();

void solve(){

    find_head();
    find_heart();
    arm_length();
    waist_length();
    leg_length();

}
void find_head(){

    for(int i=0; i<N; i++){
        for(int j=0;j<N; j++){
            if(board[i][j] == '*'){
                head_x = i;
                head_y = j;
                return;
            }
        }
    }
}

void find_heart(){
    for(int i=head_x+1; i<N; i++){
        if(board[i][head_y-1] == '*'){
            heart_x = i;
            heart_y = head_y;
            return;
        }
    }
}
void arm_length(){

    for(int i=0; i<heart_y; i++){
        if(board[heart_x][i] == '*'){
            left_arm++;
        }
    }
    for(int i=heart_y+1;i<N; i++){
        if(board[heart_x][i] == '*'){
            right_arm++;
        }
    }

}

void waist_length(){
    for(int i=heart_x+1; i<N; i++){
        if(board[i][heart_y] == '*'){
            waist++;
        }else{
            leg_start_x = i;
            return;
        }
    }
}

void leg_length(){

    for(int i = leg_start_x ; i < N ; i++){
        if(board[i][heart_y-1] == '*') left_leg++;
        if(board[i][heart_y+1] == '*') right_leg++;
    }


}


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin >> board[i][j];
        }
    }

    solve();


    cout << ++heart_x << " " << ++heart_y << "\n";
    cout << left_arm << " "<< right_arm << " " << waist << " " << left_leg << " " << right_leg;
    // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이

    return 0;

}