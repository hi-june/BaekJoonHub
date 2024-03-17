import java.util.*;

class Solution {
    private static class State {
        public final String word;
        public final int step;
        
        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(begin, 0));
        
        while (!queue.isEmpty()) {
            State state = queue.poll();
            
            if (state.word.equals(target)) {
                return state.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                
                if (!isConvertable(state.word, next)) {
                    continue;
                }
                
                if (visited[i]) {
                    continue;
                }
                
                visited[i] = true;
                queue.offer(new State(next, state.step + 1));
            }
        }
        
        return 0;
    }
    
    private boolean isConvertable(String ori, String comp) {
        int diffCount = 0;
        
        for (int i = 0; i < ori.length(); i++) {
            if (!ori.substring(i, i + 1).equals(comp.substring(i, i + 1))) {
                diffCount++;
            }
        }
        
        return diffCount == 1;
    }
}