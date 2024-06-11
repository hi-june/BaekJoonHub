import java.util.*;
import java.util.stream.*;

class Solution {
    private int[] nums;
    private int[] picked;
    private Set<String> candidates = new HashSet<>();
    
    public int solution(String[][] relation) {
        nums = new int[relation[0].length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            picked = new int[i];
            dfs(0, 0, relation);
        }
        
        return candidates.size();
    }
    
    private void dfs(int at, int depth, String[][] relation) {
        if (depth == picked.length) {
            if (isUnique(relation) && isMinimul()) {
                String key = Arrays.stream(picked)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(""));
                
                candidates.add(key);
            }
            return;
        }
        
        for (int i = at; i < nums.length; i++) {
            picked[depth] = nums[i];
            dfs(i + 1, depth + 1, relation);
        }
    }
    
    private boolean isUnique(String[][] relation) {
        Set<String> set = new HashSet<>();
        
        for (String[] r : relation) {
            String s = "";
            
            for (int idx : picked) {
                s += r[idx];
            }
            
            set.add(s);
        }
        
        return set.size() == relation.length;
    }
    
    private boolean isMinimul() {
        String key = Arrays.stream(picked)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(""));
        
        for (String candidate : candidates) {
            int count = 0;
            
            for (String c : candidate.split("")) {
                if (key.contains(c)) count++;
            }
            
            if (candidate.length() == count) return false;
        }
        
        return true;
    }
}