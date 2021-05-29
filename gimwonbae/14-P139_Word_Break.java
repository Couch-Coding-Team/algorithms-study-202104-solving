import java.util.*;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> helper = new HashSet(wordDict);
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        int longestWord = 0;
        for (String word : wordDict) {
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }
        return wordBreak(s, 0, helper, cache, longestWord);
    }

    private static boolean wordBreak(String s, int start, Set<String> wordDict, int[] cache, int lw) {
        if (start >= s.length()) {
            return true;
        }
        if (cache[start] != -1) {
            return cache[start] == 0 ? false : true;
        }
        boolean result = false;
        for (int i = start; i < start + lw && i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1))) {
                result = wordBreak(s, i + 1, wordDict, cache, lw);
            }
            if (result) {
                break;
            }
        }
        cache[start] = result ? 1 : 0;
        return result;
    }
}
