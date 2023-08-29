import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = String.valueOf(n);

        return (int)Arrays.stream(s.split(""))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}