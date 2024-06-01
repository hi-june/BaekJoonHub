import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            } 
            
            char top = stack.peek();

            if (top == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}