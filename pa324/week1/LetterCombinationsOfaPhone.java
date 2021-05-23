class Solution {
    
    private static final Map<Character, List<Character>> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        List<String> combinations = new ArrayList<>();
        if(!digits.isEmpty()) {
            dfs(digits,0,new StringBuilder(),combinations);
        }
        return combinations;
    }
    private void dfs(String digits,int i, StringBuilder current, List<String> combinations) {
        if(i == digits.length()) {
            combinations.add(current.toString());
        }
        else {
            for(char c : map.get(digits.charAt(i))) {
            dfs(digits,i+1,current.append(c),combinations);
            current.deleteCharAt(i);
            }    
        }
       
    }
}
