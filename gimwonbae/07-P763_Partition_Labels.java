import java.util.*;

class P763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new LinkedList<>();
        int start = 0;
        int max_index = Integer.MIN_VALUE;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < S.length(); i++){
            char alphabet = S.charAt(i);
            if (!visited[alphabet - 'a']) {
                visited[alphabet - 'a'] = true;
                max_index = Math.max(max_index, S.lastIndexOf(alphabet));
            }
            if (max_index == i){
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
