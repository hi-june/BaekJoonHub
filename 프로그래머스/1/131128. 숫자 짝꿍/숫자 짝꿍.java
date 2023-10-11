import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> mapX = new HashMap<>();
        Map<String, Integer> mapY = new HashMap<>();
        
        for (String s : X.split("")) {
            mapX.put(s, mapX.getOrDefault(s, 0) + 1);
        }
        
        for (String s : Y.split("")) {
            mapY.put(s, mapY.getOrDefault(s, 0) + 1);
        }
        
        Set<String> intersect = new HashSet<>(mapX.keySet());
        intersect.retainAll(mapY.keySet());
        
        if (intersect.size() == 0) {
            return "-1";
        }
        
        List<String> result = new ArrayList<>();
        for (String s : intersect) {
            int count = Math.min(mapX.get(s), mapY.get(s));
            
            for (int i = 0; i < count; i++) {
                result.add(s);
            }
        }
        
        if (Collections.frequency(result, "0") == result.size()) {
            return "0";
        }
        
        result.sort((s1, s2) -> s2.compareTo(s1));
        
        return result.stream()
            .collect(Collectors.joining(""));
    }
}