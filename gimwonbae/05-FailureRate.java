import java.util.*;

class FailureRate {
    static int[] counter;
    public int[] solution(int N, int[] stages) {
        counter = new int[N+2];
        Stage[] stage_list = new Stage[N];
        count(stages);
        for (int i = 1; i <= N; i++){
            float fail = calc(i, N);
            stage_list[i-1] = new Stage(i, fail);
        }
        Arrays.sort(stage_list);

        int[] ans = new int[N];
        for (int i = 0; i < stage_list.length; i++){
            ans[i] = stage_list[i].index;
        }
        return ans;
    }
    public void count(int[] stages){
        for (int index : stages) {
            counter[index]++;
        }
    }
    public float calc(int index, int N){
        int sum = 0;
        for (int i = index; i <= N+1; i++){
            sum += counter[i];
        }
        if (sum == 0) return 0;
        else return (float)counter[index] / (float)sum;
    }
    public class Stage implements Comparable<Stage> {
        int index;
        float fail;

        public Stage(int index, float fail){
            this.index = index;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage o1){
            if (this.fail == o1.fail) return this.index - o1.index;
            else if (this.fail - o1.fail < 0) return 1;
            else return -1;
        }
    }
}
