import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] decodeMap = new String[n];
        String format = String.format("%%0%dd", n); // n = 5, "%05d"
        
        for (int i = 0; i < n; i++) {
            decodeMap[i] = String.format(format, Long.parseLong(Long.toBinaryString(arr1[i] | arr2[i])));
        }
        
        return Arrays.stream(decodeMap)
            .map(s -> s.replace("0", " ").replace("1", "#"))
            .toArray(String[]::new);
    }
}