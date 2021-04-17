class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int size = s.length();
        String ans = "";
        while (end < size && start < size){
            String subS = s.substring(start, end+1);
            if (isP(subS)){
                ans = subS;
            }
            if (end == size - 1) {
                start++;
                end = start + ans.length();
            } else {
                end++;
            }
        }
        return ans;
    }
    public static boolean isP(String s){
        int size = s.length();
        for (int i = 0; i < size; i++){
            if (s.charAt(i) != s.charAt(size-i-1)){
                return false;
            }
        }
        return true;
    }
}