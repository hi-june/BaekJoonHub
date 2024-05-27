import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String token = str1.substring(i, i + 2);
            
            if (isAvail(token)) {
                map1.put(token, map1.getOrDefault(token, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String token = str2.substring(i, i + 2);
            
            if (isAvail(token)) {
                map2.put(token, map2.getOrDefault(token, 0) + 1);
            }
        }
        
        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        
        if (set1.size() == 0 && set2.size() == 0) {
            return 65536;
        }
        
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        
        int interSize = 0;
        for (String k : intersection) {
            interSize += Math.min(map1.get(k), map2.get(k));
        }
        
        int unionSize = 0;
        for (String k : union) {
            unionSize += Math.max(map1.getOrDefault(k, 0), map2.getOrDefault(k, 0));
        }
        
        double answer = (double)interSize / unionSize;
        
        return (int)Math.floor(answer * 65536);
    }
    
    private boolean isAvail(String token) {
        for (char c : token.toCharArray()) {
            if (c < 'a' || c > 'z') return false;
        }
        
        return true;
    }
}