import java.util.*;

class Solution {
    private static int step = 0;
    private String[] dic = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        Stack<String> stack = new Stack<>();
        
        for (String d : dic) {
            stack.push(d);
        
            while (!stack.isEmpty()) {
                String w = stack.pop();
                
                if (w.length() > 5) continue;
                
                step++;
                
                if (w.equals(word)) return step;
                
                for (int i = dic.length - 1; i >= 0; i--) {
                    stack.push(w + dic[i]);
                }
            }
        }
        
        return -1;
    }
}