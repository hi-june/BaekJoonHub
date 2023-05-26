import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        int idx = 0;
        for (int[] c : commands) {
            int i = c[0];
            int j = c[1];
            int k = c[2];
            
            int[] subArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(subArray);
            answer[idx++] = subArray[k - 1];
        }
        
        return answer;
    }
}