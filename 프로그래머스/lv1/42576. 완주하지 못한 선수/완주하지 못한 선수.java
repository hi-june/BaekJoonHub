import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> member = new HashMap<>();
        
        for (String p : participant) {
            member.put(p, member.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            member.put(c, member.get(c) - 1);
        }
        
        for (String m : member.keySet()) {
            if (member.get(m) != 0) {
                answer = m;
                break;
            }
        }
        
        return answer;
    }
}