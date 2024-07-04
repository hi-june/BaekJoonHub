import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> belt = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            belt.offer(i);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        for (int target : order) {
            while (!belt.isEmpty() && belt.peek() < target) {
                stack.push(belt.poll());
            }
            
            if (!belt.isEmpty() && belt.peek() == target) {
                belt.poll();
                count++;
            } else {
                if (stack.peek() == target) {
                    stack.pop();
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}