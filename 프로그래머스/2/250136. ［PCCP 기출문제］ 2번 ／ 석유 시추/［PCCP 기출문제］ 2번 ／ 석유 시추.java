import java.util.*;

class Solution {
    private class Node {
        private int col, row;
        
        private Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    
    private int count;
    private Set<Integer> set;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] land) {
        int[] acc = new int[land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) continue;
                
                count = 0;
                set = new HashSet<>();
                
                // dfs start
                Stack<Node> nodes = new Stack<>();
                
                nodes.push(new Node(i, j));
                land[i][j] = 0;
                set.add(j);
                count++;
                
                while (!nodes.isEmpty()) {
                    Node node = nodes.pop();
                    
                    for (int[] d : directions) {
                        int dCol = node.col + d[0];
                        int dRow = node.row + d[1];

                        if (dCol < 0 || dCol >= land.length || dRow < 0 || dRow >= land[0].length) continue;
                        if (land[dCol][dRow] == 0) continue;

                        nodes.push(new Node(dCol, dRow));
                        land[dCol][dRow] = 0;
                        set.add(dRow);
                        count++;
                    }
                }
                
                for (int r : set) {
                    acc[r] += count;
                }
            }
        }
        
        return Arrays.stream(acc).max().getAsInt();
    }
}