import java.util.*;

class Solution {
    public int solution(int n) {        
        Stack<Integer> stack = new Stack<>();
        
        while ((int)(n / 3) != 0) {
            stack.push(n % 3);
            n = (int)(n / 3);
        }
        stack.push(n % 3);
        
        int p = 0;
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop() * Math.pow(3, p++);
        }
        
        return answer;
    }
}