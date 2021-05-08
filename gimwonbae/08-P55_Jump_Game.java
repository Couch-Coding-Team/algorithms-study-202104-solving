public class P55_Jump_Game {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        int end = 0;
        for (int i = 0; i < N; i++){
            int step = nums[i];
            end = Math.max(i + step, end);
            if (end >= N - 1){
                return true;
            }
            else if (end == i) return false;
        }
        return true;
    }
}
