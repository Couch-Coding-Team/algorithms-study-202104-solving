import java.util.*;

class Kakao_krain_doll {
    static Stack<Integer>[] map;
    static Stack<Integer> bucket;
    static int ans;
    static int N;

    public int solution(int[][] board, int[] moves) {
        N = board.length;
        makeStack(board);
        for (int move : moves) {
            pushItem(move);
        }
        return ans;
    }
    public void makeStack(int[][] board){
        map = new Stack[N + 1];
        for (int i = 1; i <= N; i++){
            map[i] = new Stack<>();
            int j = N - 1;
            while(j >= 0 && board[j][i-1] != 0){
                map[i].add(board[j][i-1]);
                j--;
            }
        }
        bucket = new Stack<>();
    }
    public void pushItem(int index){
        if (!map[index].isEmpty()) {
            int item = map[index].pop();
            if (bucket.isEmpty()) bucket.push(item);
            else {
                if (bucket.peek() == item) {
                    bucket.pop();
                    ans = ans + 2;
                }
                else bucket.push(item);
            }
        }
    }
}