class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        dfs(output,n,0,0,"");
        return output;
    }
    
    public void dfs(List<String> output,int n,int open, int close, String str) {
        if(str.length() == n * 2) {
            output.add(str);
            return;
        }
        
        if(open < n) {
            dfs(output,n,open+1,close,str + "(");
        }
        
        if(close < open){
            dfs(output,n,open,close+1, str + ")");
        }
    }
 
}
