import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) { 
        int[] pointers = new int[board[0].length];
        Arrays.fill(pointers, -1);

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    pointers[i] = j;
                    break;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int m : moves) {
            int idx = m - 1;

            if (pointers[idx] == -1) continue;

            int doll = board[pointers[idx]][idx];

            if (stack.empty()) {
                stack.push(doll);
            } else if (stack.peek() != doll) {
                stack.push(doll);
            } else {
                stack.pop();
                count++;
            }

            pointers[idx] = (pointers[idx] + 1 >= board.length) ? -1 : pointers[idx] + 1;
        }
        
        return count * 2;
    }
}