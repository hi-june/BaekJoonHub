import java.util.*;

// DP
class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        int[] dp = new int[y + 1];
        
        for (int num = x; num < y; num++) {
            if (num != x && dp[num] == 0) continue;
            
            if (num + n <= y) dp[num + n] = (dp[num + n] == 0) ? dp[num] + 1 : Math.min(dp[num] + 1, dp[num + n]);
            if (num * 2 <= y) dp[num * 2] = (dp[num * 2] == 0) ? dp[num] + 1 : Math.min(dp[num] + 1, dp[num * 2]);
            if (num * 3 <= y) dp[num * 3] = (dp[num * 3] == 0) ? dp[num] + 1 : Math.min(dp[num] + 1, dp[num * 3]);
        }
        
        return dp[y] == 0 ? -1 : dp[y];
    }
}