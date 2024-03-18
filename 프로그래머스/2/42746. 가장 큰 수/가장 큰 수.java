import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
                int i1 = Integer.parseInt(s1 + s2);
                int i2 = Integer.parseInt(s2 + s1);
                
                return i2 - i1;
            })
            .collect(Collectors.joining(""));
        
        return result.charAt(0) == '0' ? "0" : result;
    }
}