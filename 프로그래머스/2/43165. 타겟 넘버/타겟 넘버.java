import java.util.*;

class Solution {
    private static class State {
        public int idx;
        public int acc;
        
        public State(int idx, int acc) {
            this.idx = idx;
            this.acc = acc;
        }
    }
    
    public int solution(int[] numbers, int target) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0));
        
        int count = 0;
        while (!stack.isEmpty()) {
            State state = stack.pop();
            
            if (state.idx == numbers.length) {
                if (state.acc == target) {
                    count++;
                }
                
                continue;
            }
            
            stack.push(new State(state.idx + 1, state.acc + numbers[state.idx]));
            stack.push(new State(state.idx + 1, state.acc - numbers[state.idx]));
        }
        
        return count;
    }
}