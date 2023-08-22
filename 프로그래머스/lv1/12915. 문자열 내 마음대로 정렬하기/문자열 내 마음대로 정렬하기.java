import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            int compare = s1.substring(n, n + 1).compareTo(s2.substring(n, n + 1));
            
            if (compare == 0) return s1.compareTo(s2);
            
            return compare;
        });
        
        return strings;
    }
}