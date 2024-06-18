import java.util.*;
import java.util.stream.*;

class Solution {
    private Map<String, Integer> cases = new HashMap<>();
    private Map<Integer, Integer> records = new HashMap<>();
    private String[] letters;
    private String[] picked;
    
    public String[] solution(String[] orders, int[] course) {
        for (int c : course) {
            records.put(c, 0);
        }
        
        for (String order : orders) {
            letters = order.split("");
            Arrays.sort(letters);
            
            for (int n : course) {
                if (letters.length < n) continue;
                
                picked = new String[n];
                dfs(0, 0);
            }
        }
        
        
        
        List<String> answer = new ArrayList<>();
        for (int c : course) {
            for (String key : cases.keySet()) {
                if (key.length() == c && records.get(c) >= 2 && cases.get(key) == records.get(c)) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }
    
    private void dfs(int at, int depth) {
        if (depth == picked.length) {
            String key = Arrays.stream(picked)
                .collect(Collectors.joining(""));
            
            cases.put(key, cases.getOrDefault(key, 0) + 1);
            records.put(key.length(), Math.max(records.get(key.length()), cases.get(key)));
            
            return;
        }
        
        for (int i = at; i < letters.length; i++) {
            picked[depth] = letters[i];
            dfs(i + 1, depth + 1);
        }
    }
}