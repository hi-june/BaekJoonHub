import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        List<Integer> nums = Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
        
        int idx = 0;
        for (int[] c : commands) {
            int i = c[0];
            int j = c[1];
            int k = c[2];
            
            List<Integer> subNums = new ArrayList<>(nums.subList(i - 1, j));
            Collections.sort(subNums);
            answer[idx++] = subNums.get(k - 1);
        }
        
        return answer;
    }
}