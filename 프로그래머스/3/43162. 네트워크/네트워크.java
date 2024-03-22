import java.util.*;

class Solution {
    /*
    [ 
    [1,1,0],
    [1,1,0],
    [0,0,1]
    ]
    */
    
    private static class Node {
        public int col;
        public int row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // visit all
                Queue<Integer> queue = new LinkedList<>();
                
                queue.offer(i);
                visited[i] = true;
                
                while (!queue.isEmpty()) {
                    int computer = queue.poll();
                    
                    for (int adj = 0; adj < n; adj++) {
                        if (visited[adj]) {
                            continue;
                        }
                        
                        if (computers[computer][adj] == 0 || adj == computer) {
                            continue;
                        }
                        
                        queue.offer(adj);
                        visited[adj] = true;
                    }
                }
                
                // count
                count++;
            }
        }
        
        return count;
    }
}