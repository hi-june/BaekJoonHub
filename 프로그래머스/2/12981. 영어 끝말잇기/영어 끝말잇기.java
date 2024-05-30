import java.util.*;

class Solution {
    // 탈락 조건
    // 1. 첫 글자 규칙 어기기
    // 2. 말했던 글자 규칙 어기기
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        char tmp = words[0].charAt(words[0].length() - 1);
        
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != tmp || set.contains(words[i])) {
                int quotient = i / n;
                int remainder = i % n;
                
                return new int[]{remainder + 1, quotient + 1};
            }
            
            set.add(words[i]);
            tmp = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}