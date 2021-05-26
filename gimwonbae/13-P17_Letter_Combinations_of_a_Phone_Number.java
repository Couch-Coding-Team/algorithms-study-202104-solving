import java.util.*;

public class P17_Letter_Combinations_of_a_Phone_Number {
    static String[] phone = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        if (digits.equals("")) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, sb);
        return ans;
    }
    public void dfs(int depth, String digits, StringBuilder sb){
        if (depth == digits.length()){
            ans.add(sb.toString());
            return;
        }
        int pos = digits.charAt(depth) - '2';
        String text = phone[pos];
        int n = text.length();
        for (int i = 0; i < n; i++){
            sb.append(text.charAt(i));
            dfs(depth + 1, digits, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
