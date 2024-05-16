class Solution {
    private long[] mem;
    
    public long solution(int n) {
        if (n == 1) return 1;
        
        // an = a(n - 1) + a(n - 2)
        mem = new long[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        
        return jump(n);
    }
    
    private long jump(int n) {
        if (mem[n] != 0) return mem[n];
        
        return mem[n] = (jump(n - 1) + jump(n - 2)) % 1234567;
    }
}