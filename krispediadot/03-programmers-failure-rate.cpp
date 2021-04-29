// 00:32:00
/*
테스트 1 〉	통과 (0.01ms, 3.99MB)
테스트 2 〉	통과 (0.03ms, 3.97MB)
테스트 3 〉	통과 (0.28ms, 4.01MB)
테스트 4 〉	통과 (1.10ms, 6.54MB)
테스트 5 〉	통과 (2.00ms, 9.89MB)
테스트 6 〉	통과 (0.05ms, 3.93MB)
테스트 7 〉	통과 (0.14ms, 3.96MB)
테스트 8 〉	통과 (1.11ms, 6.58MB)
테스트 9 〉	통과 (2.22ms, 9.94MB)
테스트 10 〉	통과 (1.14ms, 6.28MB)
테스트 11 〉	통과 (1.38ms, 6.61MB)
테스트 12 〉	통과 (1.58ms, 7.77MB)
테스트 13 〉	통과 (1.64ms, 8.36MB)
테스트 14 〉	통과 (0.02ms, 3.91MB)
테스트 15 〉	통과 (0.74ms, 5.29MB)
테스트 16 〉	통과 (0.39ms, 4.52MB)
테스트 17 〉	통과 (0.67ms, 5.29MB)
테스트 18 〉	통과 (0.37ms, 4.35MB)
테스트 19 〉	통과 (0.09ms, 3.95MB)
테스트 20 〉	통과 (0.49ms, 4.75MB)
테스트 21 〉	통과 (0.95ms, 6.29MB)
테스트 22 〉	통과 (2.77ms, 9.93MB)
테스트 23 〉	통과 (2.94ms, 9.73MB)
테스트 24 〉	통과 (2.06ms, 9.69MB)
테스트 25 〉	통과 (0.01ms, 3.96MB)
테스트 26 〉	통과 (0.01ms, 3.74MB)
테스트 27 〉	통과 (0.01ms, 3.9MB)
*/

#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    // 1. 스테이지 개수 세기
    unordered_map<int, int> m;
    for (auto s : stages) m[s]++;
        
    // 2. 실패율 계산
    vector<pair<float, int>> failure; // {실패율, 스테이지}
    
    int people = stages.size();
    for (int stage = 1; stage <= N; stage++) {
        if (m.find(stage) == m.end()) failure.push_back({0, stage});
        else {
            int blocked = m[stage];
            
            // 실패율 = 클리어 못한 사람 수 / 도전한 사람 수
            failure.push_back({(float)blocked / people, stage});
            people -= blocked;
        }
    }
    
    // 3. 실패율 큰 순서대로 정렬
    auto cmp = [](pair<float, int>& a, pair<float, int>& b) {
        if (a.first == b.first) return a.second < b.second;
        return a.first > b.first;
    };
    sort(failure.begin(), failure.end(), cmp);
    
    // 4. vector로 결과 값 옮기기
    for (auto f : failure) {
        answer.push_back(f.second);
    }

    return answer;
}
