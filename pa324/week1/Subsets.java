class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,result,new ArrayList<>(),0);
        return result;
    }
    
    public void dfs(int [] nums, List<List<Integer>> result, List<Integer> list, int start ) {
        result.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,result,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}
