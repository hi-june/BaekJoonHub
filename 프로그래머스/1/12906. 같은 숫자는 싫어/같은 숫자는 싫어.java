import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num = 0; num < arr.length; num++) {
            if (stack.isEmpty()) { // if stack is empty
                stack.push(arr[num]);
                continue;
            }
            
            int targetNum = arr[num];
            int topNum = stack.peek();

            if (targetNum == topNum) continue;
            
            stack.push(targetNum);
        }
        
        // [ 1, 3, 0, 1
        // [ * * * * ]
        int[] answer = new int[stack.size()];
        int idx = answer.length - 1;
        
        while (!stack.isEmpty()) {
            int n = stack.pop();
            
            answer[idx] = n;
            idx--;
        }
        

        return answer;
    }
}