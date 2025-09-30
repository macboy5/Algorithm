#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int start, target;


int isVisited[100001];
void BFS(){ 
        
    queue <int> q;
    q.push(start);
    isVisited[start] = 0;


    while (!q.empty()) {

        int curr = q.front();
        q.pop();

        //뒤로 한칸 이동
        int tmp1 = curr - 1;
        if (tmp1 >= 0 && tmp1 <= 100000) {
            if (isVisited[tmp1] == 0) {
                isVisited[tmp1] = isVisited[curr] + 1;
                q.push(tmp1);
            }
        }
        //앞으로 한칸 이동
        int tmp2 = curr + 1;
        if (tmp2 >= 0 && tmp2 <= 100000) {
            if (isVisited[tmp2] == 0) {
                isVisited[tmp2] = isVisited[curr] + 1;
                q.push(tmp2);
            }
        }
        //2*X만큼 순간이동
        int tmp3 = curr * 2;
        if (tmp3 >= 0 && tmp3 <= 100000) {
            if (isVisited[tmp3] == 0) {
                isVisited[tmp3] = isVisited[curr] + 1;
                q.push(tmp3);
            }
        }
    }


}

int main() {

    cin >> start >> target;

    BFS();

    if (start == target) cout << 0;
    else cout << isVisited[target];

    return 0;
}
