import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] sizes) {        
        int[] widthes = new int[sizes.length];
        int[] heights = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++) {
            widthes[i] = Math.max(sizes[i][0], sizes[i][1]);
            heights[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int maxWidth = Arrays.stream(widthes).max().getAsInt();
        int maxHeight = Arrays.stream(heights).max().getAsInt();
        
        return maxWidth * maxHeight;
    }
}