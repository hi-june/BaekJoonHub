import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> mail = new HashMap<>();
        for (String id : id_list) {
            mail.put(id, 0);
        }
        
        Map<String, Set<String>> black = new HashMap<>();
        for (String r : report) {
            String[] s = r.split(" ");
            
            String from = s[0];
            String to = s[1];
            
            if (black.containsKey(to)) {
                black.get(to).add(from);
            } else {
                Set<String> set = new HashSet<>();
                set.add(from);
                black.put(to, set);
            }
        }
        
        for (String b : black.keySet()) {
            int count = black.get(b).size();
            
            if (count >= k) {
                for (String s : black.get(b)) {
                    mail.put(s, mail.get(s) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }
        
        return answer;
    }
}