import java.util.*;

public class P78_Subsets {
    static boolean visited[];
    static List<List<Integer>> ans;
    static List<Integer> tmp;
    static int N;
    public List<List<Integer>> subsets(int[] nums) {
        N = nums.length;
        visited = new boolean[N];

        tmp = new LinkedList<>();
        ans = new LinkedList<>();
        ans.add(tmp);
        dfs(0, nums);
        return ans;
    }
    public void dfs(int depth, int[] nums){
        if (depth == N) return;
        for (int i = depth; i < N; i++){
            if (!visited[i]){
                tmp.add(nums[i]);
                visited[i] = true;
                addTmp(tmp);
                dfs(depth + 1, nums);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public void addTmp(List<Integer> tmp){
        List<Integer> newTmp = new LinkedList<>();
        for (int x : tmp){
            newTmp.add(x);
        }
        ans.add(newTmp);
    }
}
