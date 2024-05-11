import java.util.*;
import java.util.stream.*;

class Solution {
    int solution(int[][] land) {        
        for (int idx = land.length - 1; idx >= 1; idx--) {
            int upIdx = idx - 1;
            int[] upCol = land[upIdx];
            
            int[] targetCol = land[idx];
            for (int i = 0; i < 4; i++) {
                upCol[i] += getMax(i, targetCol);
            }
        }

        return Arrays.stream(land[0]).max().getAsInt();
    }
    
    private int getMax(int idx, int[] targetCol) {
        int max = 0;
        
        for (int i = 0; i < 4; i++) {
            if (i == idx) continue;
            
            if (targetCol[i] > max) max = targetCol[i];
        }
        
        return max;
    }
}