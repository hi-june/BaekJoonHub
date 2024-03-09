import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 0) return new int[0];

        Stack<Integer> stack = new Stack<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            int day = (100 - progresses[i]) / speeds[i];
            stack.push(((100 - progresses[i]) % speeds[i] == 0) ? day : day + 1);
        }


        List<Integer> answer = new ArrayList<>();

        while (!stack.isEmpty()) {
            int first = stack.pop();
            int count = 1;

            while (!stack.isEmpty() && stack.peek() <= first) {
                stack.pop();
                count++;
            }
            answer.add(count);
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}