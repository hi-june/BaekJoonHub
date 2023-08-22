class Solution {
    public long solution(int a, int b) {
        long total = 0;
        
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            total += i;
        }
        
        return total;
    }
}