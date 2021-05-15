import java.util.*;

public class P46_Permutations {
    static boolean[] visited;
    static int N;
    static List<Integer> arr;
    static List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        N = nums.length;
        ans = new LinkedList<>();
        arr = new LinkedList<>();
        visited = new boolean[N];

        dfs(0, nums);
        return ans;
    }
    public void dfs(int depth, int[] nums){
        if (depth == N){
            List<Integer> tmp = new LinkedList<>();
            for (int x : arr){
                tmp.add(x);
            }
            ans.add(tmp);
            return;
        }
        for (int i = 0; i < N; i++){
            if (!visited[i]) {
                arr.add(nums[i]);
                visited[i] = true;
                dfs(depth + 1, nums);
                visited[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }
}
