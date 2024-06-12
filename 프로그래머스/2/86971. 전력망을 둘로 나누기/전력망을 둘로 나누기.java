import java.util.*;

class Solution {    
    List<List<Integer>> map = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        // map init
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            List<Integer> info1 = map.get(wire[0] - 1);
            List<Integer> info2 = map.get(wire[1] - 1);
            
            info1.add(wire[1] - 1);
            info2.add(wire[0] - 1);
        }
        
        // start
        List<List<Integer>> histories = new ArrayList<>();
        for (int[] wire : wires) {
            // cut wire
            List<Integer> info1 = map.get(wire[0] - 1);
            List<Integer> info2 = map.get(wire[1] - 1);
            
            info1.remove(Integer.valueOf(wire[1] - 1));
            info2.remove(Integer.valueOf(wire[0] - 1));
            
            // calculate
            boolean[] visited = new boolean[n];
            List<Integer> history = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                
                history.add(bfs(i, visited));
            }
            histories.add(history);
            
            // rollback            
            info1.add(wire[1] - 1);
            info2.add(wire[0] - 1);
        }
        
        int diff = Math.abs(histories.get(0).get(0) - histories.get(0).get(1));
        for (int i = 1; i < histories.size(); i++) {
            int diffTmp = Math.abs(histories.get(i).get(0) - histories.get(i).get(1));
            
            diff = Math.min(diff, diffTmp);
        }
        
        return diff;
    }
    
    private int bfs(int n, boolean[] visited) {
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int adjNode : map.get(node)) {
                if (visited[adjNode]) continue;
                
                visited[adjNode] = true;
                count++;
                queue.offer(adjNode);
            }
        }
        
        return count;
    }
}