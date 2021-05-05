class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S.charAt(0) == S.charAt(S.length()-1)) {
            result.add(S.length());
            return result;
        }
        
        HashMap<Character,Integer> map =  new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i),i);
        }
        
        int max = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            max = Math.max(max, map.get(S.charAt(i)));
            if(i == max) {
                result.add(max - start + 1);
                start = i+1;
                max = 0;
            }
        }
        
        return result;
        
    }
}
