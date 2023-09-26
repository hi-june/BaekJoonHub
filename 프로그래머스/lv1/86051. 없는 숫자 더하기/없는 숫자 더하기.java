import java.util.*;

class Solution {
    static final int total = 45;
    
    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        
        return total - sum;
    }
}