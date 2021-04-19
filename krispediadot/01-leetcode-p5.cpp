#include <iostream>
#include <vector>

using namespace std;

// 1016ms, 385.8MB
class Solution1 {
    vector<vector<int>> dp;
    string answer;
public:
    string longestPalindrome(string s) {
        dp.clear();
        dp.resize(s.length(), vector<int>(s.length(), 0));
        answer = "";
        
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start; end < s.length(); end++) {
                if (start == end) dp[start][end] = 1;
                
                else if (s[start] == s[end]) {
                    dp[start][end] = dp[start + 1][end - 1] + 2 * (dp[start + 1][end - 1] != 0);

                    if (end - start + 1 == 2) dp[start][end] = 2;
                } 
                
                if (dp[start][end] > answer.length()) {
                    answer = s.substr(start, end - start + 1);
                }
            }
        }
        return answer;
    }
};

// 88ms, 231.6MB
class Solution2 {
public:
    string longestPalindrome(string s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = countLongestPalindrome(s, i, i);
            int even = countLongestPalindrome(s, i, i + 1);

            int max_result = max(odd, even);

            if (max_result > end - start) {
                start = i - ((max_result - 1) / 2);
                end = i + (max_result / 2);
            }
        }

        return s.substr(start, end - start + 1);
    }
    int countLongestPalindrome(string s, int left, int right) {
        if (left > right) return 0;

        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
};

// 4ms, 7.1MB
class Solution3 {
public:
    string longestPalindrome(string s) {
        int answer_start = 0, answer_end = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i, end = i;

            while (end + 1 < s.length() && s[end + 1] == s[start]) {
                end++;
            }

            i = end;

            while (start - 1 >= 0 && end + 1 < s.length() &&
                s[start - 1] == s[end + 1]) {
                end++;
                start--;
            }

            if (end - start + 1 > answer_end - answer_start + 1) {
                answer_start = start;
                answer_end = end;
            }
        }
        return s.substr(answer_start, answer_end - answer_start + 1);
    }
};

int main() {
    Solution1 sol;
    cout << sol.longestPalindrome("babad") << endl; // bab
    cout << sol.longestPalindrome("cbbd") << endl; // bb
    cout << sol.longestPalindrome("a") << endl; // a
    cout << sol.longestPalindrome("ac") << endl; // a
    cout << sol.longestPalindrome("aacabdkacaa") << endl; // aca

	Solution2 sol;
    cout << sol.longestPalindrome("babad") << endl; // bab
    cout << sol.longestPalindrome("cbbd") << endl; // bb
    cout << sol.longestPalindrome("a") << endl; // a
    cout << sol.longestPalindrome("ac") << endl; // a
    cout << sol.longestPalindrome("aacabdkacaa") << endl; // aca

	Solution3 sol;
    cout << sol.longestPalindrome("babad") << endl; // bab
    cout << sol.longestPalindrome("cbbd") << endl; // bb
    cout << sol.longestPalindrome("a") << endl; // a
    cout << sol.longestPalindrome("ac") << endl; // a
    cout << sol.longestPalindrome("aacabdkacaa") << endl; // aca
}
