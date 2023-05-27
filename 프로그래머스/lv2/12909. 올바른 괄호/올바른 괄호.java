import java.util.*;

class Solution {
    boolean solution(String s) {
        final String OPEN = "(";
        final String CLOSE = ")";
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i, i + 1);
            
            if (stack.isEmpty()) {
                if (ss.equals(CLOSE)) {
                    return false;
                }
                stack.push(ss);
                continue;
            }
            
            if (ss.equals(CLOSE)) {
                stack.pop();
            } else {
                stack.push(ss);
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}