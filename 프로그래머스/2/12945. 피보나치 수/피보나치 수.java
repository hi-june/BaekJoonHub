import java.util.*;

class Solution {
    private int[] mem = new int[100001];
    
    public int solution(int n) {
        Arrays.fill(mem, -1);
        
        for (int i = 0; i <= n; i++) {
            fibo(i);
        }
        
        return mem[n];
    }
    
    private int fibo(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        
        mem[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        
        return mem[n];
    }
}