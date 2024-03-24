import java.util.*;
import java.util.stream.*;

class Solution {
    private static class Node {
        int idx;
        int step;
        
        private Node(int idx, int step) {
            this.idx = idx;
            this.step = step;
        }
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> maps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            maps.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int n1 = e[0] - 1;
            int n2 = e[1] - 1;
            
            maps.get(n1).add(n2);
            maps.get(n2).add(n1);
        }
        
        int[] steps = new int[n];
        boolean[] visited = new boolean[n];
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Integer> map = maps.get(node.idx);
            
            for (int m : map) {
                if (visited[m]) {
                    continue;
                }
                
                steps[m] = node.step;
                visited[m] = true;
                queue.offer(new Node(m, node.step + 1));
            }
        }
        
        int maxStep = Arrays.stream(steps)
            .max()
            .getAsInt();
        
        int maxCount = (int)Arrays.stream(steps)
            .filter(i -> i == maxStep)
            .count();
        
        return maxCount;
    }
}