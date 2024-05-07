class Solution {
    // 이게 피보나치 인 걸 어케 아노;;
    private int[] mem;
    private static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        mem = new int[n + 1];
        
        mem[1] = 1;
        mem[2] = 2;
        
        return fibo(n);
    }
    
    private int fibo(int n) {
        if (n == 1 || n == 2) return mem[n];
        
        if (mem[n] != 0) {
            return mem[n];
        }
        
        return mem[n] = (fibo(n - 1) + fibo(n - 2)) % MOD;
    }
}