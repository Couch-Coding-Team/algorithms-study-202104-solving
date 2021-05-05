class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S==null || S.length() == 0) {
            return null;
        }
        if(S.charAt(0) == S.charAt(S.length() - 1)) {
            return List.of(S.length());
        }
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i),i);
        }
        int firstIndex = 0;
        int lastIndex = 0;
        for(int i = 0; i < S.length(); i++) {
            lastIndex = Math.max(lastIndex, map.get(S.charAt(i)));
            if(i == lastIndex) {
                result.add(lastIndex - firstIndex + 1);
                firstIndex = lastIndex + 1;
            }
        }
        
        return result;
    }
}
