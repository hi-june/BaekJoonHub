import java.util.*;

class Solution {    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visitAll(i, computers, visited);
                count++;
            }
        }
        
        return count;
    }
    
    private void visitAll(int computer, int[][] computers, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(computer);
        visited[computer] = true;
        
        while (!stack.isEmpty()) {
            int c = stack.pop();
            
            for (int adjComputer = 0; adjComputer < computers[c].length; adjComputer++) {
                if (computers[c][adjComputer] == 1 && !visited[adjComputer]) {
                    stack.push(adjComputer);
                    visited[adjComputer] = true;
                }
            }
        }
    }
}