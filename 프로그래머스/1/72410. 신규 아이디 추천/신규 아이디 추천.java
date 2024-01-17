import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();
        
        // 2
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4
        if (new_id.length() != 0 && new_id.substring(0, 1).equals(".")) {
            new_id = new_id.substring(1, new_id.length());
        }
        if (new_id.length() != 0 && new_id.substring(new_id.length() - 1, new_id.length()).equals(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        // 5
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        
        // 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        
        // 7
        while (new_id.length() <= 2) {
            new_id = new_id + new_id.substring(new_id.length() - 1, new_id.length());
        }
        
        return new_id;
    }
}