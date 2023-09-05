import java.util.*;

class Solution {
    public double solution(int[] arr) {
        int total = Arrays.stream(arr).sum();
        
        return (double)(total) / arr.length;
    }
}