import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for (String skillCase : skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            for (String s : skillCase.split("")) {
                if (skill.contains(s)) {
                    sb.append(s);
                }
            }
            
            if (skill.startsWith(sb.toString())) {
                count += 1;
            }
        }
        
        return count;
    }
}