class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        backtrack(res,nums, 0, sublist);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res,int[] nums, int start, List<Integer> sublist) {
        if (sublist.size() == nums.length) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        
        ArrayList<Integer> newPerm = new ArrayList<Integer>(sublist);
        for(int j = 0; j <= start; j++){
            newPerm.add(j, nums[start]);
            backtrack(res,nums, start+1, newPerm);
            newPerm.remove(j);
        }
    }
}
