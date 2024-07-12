import java.util.*;

class Solution {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<Integer> avail = new ArrayList<>();
    private String[][] map;
    private boolean[][] visited;
    private int acc = 0;
    
    public int[] solution(String[] maps) {
        map = new String[maps.length][];
        visited = new boolean[maps.length][];
        
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
            visited[i] = new boolean[map[i].length];
            
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("X")) {
                    visited[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (visited[i][j]) continue;
                
                acc += Integer.parseInt(map[i][j]);
                visited[i][j] = true;
                addAll(i, j);
                
                if (acc > 0) {
                    avail.add(acc);
                    acc = 0;
                }
            }
        }
        
        if (avail.isEmpty()) return new int[]{-1};
        
        return avail.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private void addAll(int col, int row) {
        for (int[] d : directions) {
            int dCol = col + d[0];
            int dRow = row + d[1];
            
            if (dCol < 0 || dCol >= map.length || dRow < 0 || dRow >= map[0].length) continue;
            if (visited[dCol][dRow]) continue;
            
            visited[dCol][dRow] = true;
            acc += Integer.parseInt(map[dCol][dRow]);
            
            addAll(dCol, dRow);
        }
    }
}