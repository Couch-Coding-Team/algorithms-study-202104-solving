class p647 {
    public int countSubstrings(String s) {
        int size = s.length();
        int ans = 0;

        for (int i = 0; i < size; i++){
            for (int j = i+1; j <= size; j++){
                if (isPalid(s.substring(i, j))){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPalid(String s){
        int size = s.length();
        for (int i = 0; i < size / 2; i++){
            if (s.charAt(i) != s.charAt(size-i-1)){
                return false;
            }
        }
        return true;
    }
}
