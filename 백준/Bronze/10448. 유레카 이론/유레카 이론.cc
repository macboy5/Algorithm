#include <iostream>
#include <vector>

using namespace std;

// 주어진 수가 세 개의 삼각수의 합으로 나타낼 수 있는지 확인하는 함수
int checkEureka(int num, const vector<int>& tri_nums) {
    // 3중 for문을 사용하여 모든 삼각수 조합의 합을 확인
    for (int i = 0; i < tri_nums.size(); i++) {
        for (int j = 0; j < tri_nums.size(); j++) {
            for (int k = 0; k < tri_nums.size(); k++) {
                if (tri_nums[i] + tri_nums[j] + tri_nums[k] == num) {
                    return 1; // 조건을 만족하면 1 반환
                }
            }
        }
    }
    return 0; // 조건을 만족하는 조합이 없으면 0 반환
}

int main() {
    // 1000 이하의 모든 삼각수를 미리 계산하여 저장
    vector<int> tri_nums;
    int sum = 0;
    for (int i = 1; sum <= 1000; i++) {
        sum += i;
        tri_nums.push_back(sum);
    }

    int K;
    cin >> K;

    for (int i = 0; i < K; i++) {
        int n;
        cin >> n;
        cout << checkEureka(n, tri_nums) << '\n';
    }

    return 0;
}