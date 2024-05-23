import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        List<Integer> nums = Arrays.stream(s.split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        
        return String.format("%d %d", Collections.min(nums), Collections.max(nums));
    }
}