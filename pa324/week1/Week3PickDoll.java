import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int item = board[j][moves[i] - 1];
                if(item != 0) {
                    board[j][moves[i] - 1] = 0;
                    answer+=countDuplicatedItem(s,item);
                    break;
                }
            }
        }

        return answer;
    }

    public int countDuplicatedItem(Stack<Integer> stack, int item) {

        int duplicatedCount = 0;
        boolean isDuplicated = false;

        while(!stack.isEmpty() && stack.peek() == item) {
            duplicatedCount++;
            stack.pop();
            isDuplicated = true;
        }

        if(isDuplicated) duplicatedCount++;
        else stack.push(item);


        return duplicatedCount;
    }
}
