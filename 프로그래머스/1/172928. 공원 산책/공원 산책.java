import java.util.*;

class Solution {
    private static final Map<String, List<Integer>> directions = Map.of(
        "N", List.of(-1, 0),
        "S", List.of(1, 0),
        "W", List.of(0, -1),
        "E", List.of(0, 1)
    );
    private static int[][] map;
    
    public int[] solution(String[] park, String[] routes) {
        map = new int[park.length][park[0].length()];
        
        int sCol = 0;
        int sRow = 0;
        for (int col = 0; col < map.length; col++) {
            for (int row = 0; row < map[0].length; row++) {
                char c = park[col].charAt(row);
                
                if (c == 'S') {
                    sCol = col;
                    sRow = row;
                    continue;
                }
                
                if (c == 'X') map[col][row] = 1;
            }
        }
        
        int eCol = sCol;
        int eRow = sRow;
        for (String r : routes) {
            if (!isAvail(eCol, eRow, r)) continue;
            
            List<Integer> d = directions.get(r.substring(0, 1));
            int n = Integer.parseInt(r.substring(2, 3));
            eCol += d.get(0) * n;
            eRow += d.get(1) * n;
        }
        
        return new int[]{eCol, eRow};
    }
    
    private static boolean isAvail(int eCol, int eRow, String route) {
        String d = route.substring(0, 1);
        int n = Integer.parseInt(route.substring(2, 3));
        
        int dCol = eCol + directions.get(d).get(0) * n;
        int dRow = eRow + directions.get(d).get(1) * n;
        
        if (dCol < 0 || dCol >= map.length || dRow < 0 || dRow >= map[0].length) return false;
        
        switch (d) {
            case "E": {
                for (int i = 1; i <= n; i++) {
                    if (map[eCol][eRow + i] == 1) return false;
                }
                break;
            }
            case "W": {
                for (int i = 1; i <= n; i++) {
                    if (map[eCol][eRow - i] == 1) return false;
                }
                break;
            }
            case "N": {
                for (int i = 1; i <= n; i++) {
                    if (map[eCol - i][eRow] == 1) return false;
                }
                break;
            }
            case "S": {
                for (int i = 1; i <= n; i++) {
                    if (map[eCol + i][eRow] == 1) return false;
                }
                break;
            }
        }
        
        return true;
    }
}