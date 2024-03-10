import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];

            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        int count = 1;
        
        for (Map.Entry<String, Integer> entrySet : clothesMap.entrySet()) {
            count *= (entrySet.getValue() + 1);
        }
        return count - 1;
    }
}