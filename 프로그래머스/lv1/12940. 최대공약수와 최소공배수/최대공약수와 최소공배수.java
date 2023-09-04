class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(Math.max(n, m), Math.min(n, m));
        int lcm = (n * m) / gcd;
        
        return new int[] {gcd, lcm};
    }
    
    static int getGCD(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        
        return getGCD(m, n % m);
    }
}