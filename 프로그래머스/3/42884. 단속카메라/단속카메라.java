import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        
        int count = 0;
        int checkPoint = -30_000;
        
        for (int[] route : routes) {
            int min = route[0];
            int max = route[1];
            
            if (min <= checkPoint && max >= checkPoint) {
                continue;
            }
            
            checkPoint = max;
            count++;
        }
        
        return count;
    }
}