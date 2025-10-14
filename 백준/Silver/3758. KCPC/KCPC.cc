#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // std::accumulate 또는 std::fill 사용을 위해

using namespace std;

// 팀 정보를 담는 구조체
struct TeamData {
    // 문제 번호 1부터 k까지 점수를 저장합니다. (0번 인덱스 미사용)
    int score[101] = {0,}; // 모든 요소를 0으로 초기화
    int submission_count = 0; // 풀이 횟수
    int last_submission_time = 0; // 마지막 제출 시간
    int team_id; // 팀 ID
};

// 순위를 계산하고 출력하는 함수
void solve() {
    int n, k, t, m;
    cin >> n >> k >> t >> m;

    // 1번부터 n번 팀까지 사용하기 위해 n+1 크기의 벡터 선언 및 초기화
    // TeamData B[101]; (최대 크기) 대신 벡터를 사용
    vector<TeamData> teams(n + 1);

    // 팀 ID 설정
    for (int i = 1; i <= n; ++i) {
        teams[i].team_id = i;
    }

    // 로그 처리
    for (int time = 1; time <= m; ++time) {
        int id, problem, score;
        cin >> id >> problem >> score;

        // 문제별 최고 점수 갱신
        if (teams[id].score[problem] < score) {
            teams[id].score[problem] = score;
        }

        // 제출 횟수 및 마지막 제출 시간 갱신
        teams[id].submission_count++;
        teams[id].last_submission_time = time;
    }

    // 팀별 총점을 계산하고 정렬을 위한 비교 함수 정의
    auto compare = [&](const TeamData& A, const TeamData& B) {
        // 1. 총점 계산
        int sumA = 0, sumB = 0;
        // 문제 번호 1부터 k까지 합산
        for (int i = 1; i <= k; ++i) { 
            sumA += A.score[i];
            sumB += B.score[i];
        }

        if (sumA != sumB) {
            // 점수가 높은 팀이 순위가 높다 (true)
            return sumA > sumB;
        } else {
            // 2. 제출 횟수 비교
            if (A.submission_count != B.submission_count) {
                // 제출 횟수가 적은 팀이 순위가 높다 (true)
                return A.submission_count < B.submission_count;
            } else {
                // 3. 마지막 제출 시간 비교
                // 마지막 제출 시간이 빠른 팀이 순위가 높다 (true)
                return A.last_submission_time < B.last_submission_time;
            }
        }
    };

    // 정렬 시 0번 인덱스는 사용하지 않으므로, 1번부터 n번 팀까지 정렬
    // teams.begin()+1은 teams[1]을 가리킵니다.
    sort(teams.begin() + 1, teams.end(), compare);

    // 순위 계산: 정렬된 팀 리스트에서 t팀의 위치가 순위입니다.
    // teams[1]이 1등, teams[2]가 2등, ...
    int rank = 0;
    for (int i = 1; i <= n; ++i) {
        if (teams[i].team_id == t) {
            rank = i;
            break;
        }
    }

    cout << rank << "\n";
}


int main() {
    // 입출력 속도 향상
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        solve();
    }

    return 0;
}