import java.util.*;

// 이걸 stack 쓸 생각을 어떻게 함 ㅡㅡ
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < numbers.length; idx++) {
            if (stack.isEmpty()) {
                stack.push(idx);
                continue;
            }
            
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[idx]) {
                answer[stack.pop()] = numbers[idx];
            }
                
            stack.push(idx);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}