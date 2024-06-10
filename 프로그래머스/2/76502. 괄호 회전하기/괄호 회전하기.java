import java.util.*;

class Solution {
    private Map<String, String> bracket = new HashMap<>();
    
    public int solution(String s) {
        bracket.put("(", ")");
        bracket.put("[", "]");
        bracket.put("{", "}");
        
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String right = s.substring(i);
            String left = s.substring(0, i);
            
            if (check(right + left, i)) answer++;
        }
        
        return answer;
    }
    
    private boolean check(String s, int n) {
        Stack<String> stack = new Stack<>();
        
        for (String token : s.split("")) {
            if (stack.isEmpty()) {
                if (!bracket.containsKey(token)) return false;
                
                stack.push(token);
            } else {
                if (bracket.containsKey(token)) {   // 여는 애
                    stack.push(token);
                } else {    // 닫는 애
                    if (bracket.get(stack.peek()).equals(token)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}