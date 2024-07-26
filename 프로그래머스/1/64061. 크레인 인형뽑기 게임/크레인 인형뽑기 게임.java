import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> map = new ArrayList<>();

        // i = 열
        for (int i = 0; i < board[0].length; i++) {
            Stack<Integer> stack = new Stack<>();

            // j = 행
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] == 0) break;

                stack.push(board[j][i]);
            }

            map.add(stack);
        }

        int count = 0;
        Stack<Integer> basket = new Stack<>();
        for (int m : moves) {
            if (map.get(m - 1).isEmpty()) continue;

            int block = map.get(m - 1).pop();

            if (basket.isEmpty()) {
                basket.push(block);
                continue;
            }

            if (basket.peek() == block) {
                basket.pop();
                count += 2;
            } else {
                basket.push(block);
            }
        }

        return count;
    }
}