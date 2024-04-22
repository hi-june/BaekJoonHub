import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[][] map = new int[wallpaper.length][wallpaper[0].length()];
        
        int idx = 0;
        for (String w : wallpaper) {
            map[idx++] = Arrays.stream(w.split(""))
                .mapToInt(s -> s.equals("#") ? 1 : 0)
                .toArray();
        }
        
        int leftEnd = map[0].length - 1;
        int rightEnd = 0;
        int topEnd = map.length - 1;
        int bottomEnd = 0;
        for (int col = 0; col < map.length; col++) {
            for (int row = 0; row < map[0].length; row++) {
                if (map[col][row] == 1) {
                    leftEnd = Math.min(leftEnd, row);
                    rightEnd = Math.max(rightEnd, row);
                    topEnd = Math.min(topEnd, col);
                    bottomEnd = Math.max(bottomEnd, col);
                }
            }
        }
        
        // System.out.printf("%d %d %d %d\n", leftEnd, rightEnd, topEnd, bottomEnd);
        
        return new int[]{topEnd, leftEnd, bottomEnd + 1, rightEnd + 1};
    }
}