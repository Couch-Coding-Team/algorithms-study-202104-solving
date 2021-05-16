import java.util.*;

public class P22_Generate_Parentheses {
    static List<String> ans;
    static StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        ans = new LinkedList<>();
        dfs(0, 0, 0, n);
        return ans;
    }
    public void dfs(int depth, int openCnt, int closeCnt, int n){
        if (depth == 2*n) {
            ans.add(sb.toString());
            return;
        }
        if (openCnt < n){
            sb.append('(');
            dfs(depth + 1, openCnt + 1, closeCnt, n);
            sb.setLength(sb.length() - 1);
        }
        if (closeCnt < openCnt){
            sb.append(')');
            dfs(depth + 1, openCnt, closeCnt + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
