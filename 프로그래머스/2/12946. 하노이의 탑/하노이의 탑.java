import java.util.*;

class Solution {
    private static List<List<Integer>> results = new ArrayList<>();
    
    public int[][] solution(int n) {        
        // f(n, s, e) = f(n - 1, s, middle) + {s, e} + f(n - 1, middle, e)
        hanoi(n, 1, 3);
        
        int[][] answer = new int[results.size()][2];
        
        int idx = 0;
        for (List<Integer> r : results) {
            answer[idx][0] = r.get(0);
            answer[idx][1] = r.get(1);
            idx++;
        }
        
        return answer;
    }
    
    private void hanoi(int n, int s, int e) {
        List<Integer> bridge = Arrays.asList(s, e);
        
        if (n == 1) {
            results.add(bridge);
            return;
        }
        
        int middle = 6 - (s + e);
        
        hanoi(n - 1, s, middle);
        results.add(bridge);
        hanoi(n - 1, middle, e);
    }
}