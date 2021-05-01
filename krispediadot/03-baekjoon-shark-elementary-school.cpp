#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

const int dirR[] = {-1, 0, 1, 0}; // 북동남서
const int dirC[] = {0, 1, 0, -1};
int n;

// 4방향 주위 비어있는 칸의 수
int getEmptyCnt(vector<vector<int>>& space, int r, int c) {

    auto is_valid = [&](int r, int c) { 
        return r >= 0 && r < space.size() && c >= 0 && c < space.size();
    };

    int cnt = 0;

    for (int dir = 0; dir < 4; dir++) {
        int new_r = r + dirR[dir];
        int new_c = c + dirC[dir];

        if (is_valid(new_r, new_c) && space[new_r][new_c] == 0) {
            cnt++;
        }
    }

    return cnt;
}

// 4방향 주위 좋아하는 학생수 
int getFavCnt(vector<vector<int>>& space, vector<int>& info_list, int r, int c) {

    auto is_valid = [&](int r, int c) { 
        return r >= 0 && r < space.size() && c >= 0 && c < space.size();
    };

    int cnt = 0;

    for (int dir = 0; dir < 4; dir++) {
        int new_r = r + dirR[dir];
        int new_c = c + dirC[dir];

        if (is_valid(new_r, new_c) && space[new_r][new_c] != 0) {
            if (find(info_list.begin(), info_list.end(), space[new_r][new_c]) != info_list.end())
                cnt++;
        }
    }

    return cnt;
}

// 좋아하는 학생 주위에 가장 많은 칸의 위치들
vector<pair<int, int>> getMaxFavLoc(vector<vector<int>>& space, vector<int>& info_list) {
    vector<pair<int, int>> res;

    int max_cnt = 0;

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            if (space[r][c] == 0) {

                int cnt = getFavCnt(space, info_list, r, c);

                if (cnt >= max_cnt) {
                    if (cnt > max_cnt)
                        res.clear();
                    res.push_back({r, c});
                    max_cnt = cnt;
                }
            }
        }
    }

    return res;
}

// 주변에 빈 곳이 많은 칸의 위치들
vector<pair<int, int>> getSpaciousLoc(vector<vector<int>>& space, vector<pair<int, int>>& fav_loc) {
    vector<pair<int, int>> res;

    int max_cnt = 0;

    for (int idx = 0; idx < fav_loc.size(); idx++) {
        int r = fav_loc[idx].first;
        int c = fav_loc[idx].second;

        int cnt = getEmptyCnt(space, r, c);

        if (cnt >= max_cnt) {
            if (cnt > max_cnt)
                res.clear();
            res.push_back({r, c});
            max_cnt = cnt;
        }
    }

    return res;
}

// 만족도의 총합
int solution(int n, vector<vector<int>> info) {
    vector<vector<int>> space(n, vector<int>(n, 0));

    // 1 - 자리 선정
    for (int idx = 0; idx < info.size(); idx++) {
        int target = info[idx][0];

        vector<pair<int, int>> fav_loc = getMaxFavLoc(space, info[idx]);

        // 1. 비어있는 칸 충 좋아하는 학생이 인접한 칸에 많은 칸 선택
        if (fav_loc.size() == 1) {
            space[fav_loc[0].first][fav_loc[0].second] = target;
        }
        else {
            
            vector<pair<int, int>> spacious_loc = getSpaciousLoc(space, fav_loc);

            // 2. 1을 만족하는 칸이 여러개이면, 인접 칸 중 비어있는 칸이 많은 곳 선택
            if (spacious_loc.size() == 1) {
                space[spacious_loc[0].first][spacious_loc[0].second] = target;
            }

            // 3. 2를 만족하는 칸이 여러개인 경우 행의 번호가 가장 작은 칸 그리고 열의 번호가 가장 작은 칸 선택
            else {
                auto cmp = [](pair<int, int>& a, pair<int, int>& b) {
                    if (a.first == b.first) return a.second < b.second;
                    return a.first < b.first;
                };
                sort(spacious_loc.begin(), spacious_loc.end(), cmp);

                space[spacious_loc[0].first][spacious_loc[0].second] = target;
            }
        }
    }

    sort(info.begin(), info.end(), [](vector<int>& a, vector<int>& b) { return a[0] < b[0]; });

    // 2 - 만족도 계산
    int score = 0;

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            int target = space[r][c];
            int cnt = getFavCnt(space, info[target - 1], r, c);

            // 좋아하는 학생 수 = 0, 만족도 = 0
            // 좋아하는 학생 수 = 1, 만족도 = 1
            if (cnt == 1) score += 1;
            // 좋아하는 학생 수 = 2, 만족도 = 10
            if (cnt == 2) score += 10;
            // 좋아하는 학생 수 = 3, 만족도 = 100
            if (cnt == 3) score += 100;
            // 좋아하는 학생 수 = 4, 만족도 = 1000
            if (cnt == 4) score += 1000;
        }
    }

    return score;
}

int main() {
    cin >> n;
    vector<vector<int>> info;

    for (int i = 0; i < n*n; i++) {
        vector<int> temp(5);
        int target; cin >> target;
        temp[0] = target;
        for (int j = 1; j <= 4; j++) 
            cin >> temp[j];
        
        info.push_back(temp);
    }

    cout << solution(n, info);

}
