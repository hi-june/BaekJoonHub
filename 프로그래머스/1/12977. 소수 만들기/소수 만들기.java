import java.util.*;

class Solution {
    private final int r = 3;
    private int count = 0;
    private int[] picked;
    
    public int solution(int[] nums) {
        picked = new int[r];
        backTracking(0, 0, nums);

        return count;
    }
    
    private void backTracking(int at, int depth, int[] nums) {
        if (depth == r) {
            int sum = (int)Arrays.stream(picked).sum();
            
            if (isPrime(sum)) count++;
            
            return;
        }
        
        for (int i = at; i < nums.length; i++) {
            picked[depth] = nums[i];
            backTracking(i + 1, depth + 1, nums);
        }
    }
    
    private boolean isPrime(int n) {
        if (n == 2) return true;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}