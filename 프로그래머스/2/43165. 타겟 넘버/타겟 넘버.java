import java.util.*;

class Solution {
    public static class State {
        public int idx; // 다음에 방문할 인덱스
        public int acc; // 현재까지 누적 계산값
        
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
            
            if (state.idx == numbers.length) {  // numbers를 모두 써서 계산을 완료했을 때
                if (state.acc == target) {
                    count += 1;
                }
                continue;
            }
            
            stack.push(new State(state.idx + 1, state.acc + numbers[state.idx]));
            stack.push(new State(state.idx + 1, state.acc - numbers[state.idx]));
        }
        
        return count;
    }
}