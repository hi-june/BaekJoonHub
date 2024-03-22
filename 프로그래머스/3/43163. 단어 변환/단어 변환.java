import java.util.*;

class Solution {
    private static class State {
        int step;
        String word;
        
        private State(int step, String word) {
            this.step = step;
            this.word = word;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, begin));
        
        while (!queue.isEmpty()) {
            State state = queue.poll();
            
            if (state.word.equals(target)) {
                return state.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i] || !check(state.word, words[i])) {
                    continue;
                }
                
                
                queue.offer(new State(state.step + 1, words[i]));
                visited[i] = true;
                
            }
        }
        
        return 0;
    }
    
    private boolean check(String ori, String comp) {
        int count = 0;
        
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) != comp.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
}