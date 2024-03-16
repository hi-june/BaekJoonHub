import java.util.*;

class Solution { 
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visitAll(i, computers);
                count++;
            }
        }
        
        return count;
    }
    
    private void visitAll(int startNode, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            for (int i = 0; i < computers[node].length; i++) {
                if (!visited[i] && computers[node][i] == 1) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}