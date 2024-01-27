import java.util.*;

class Solution {
    static int[] scores;
    static Map<String, Integer> table = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        scores = new int[] {0, 3, 2, 1, 0, 1, 2, 3};
        table.put("R", 0);
        table.put("T", 0);
        table.put("C", 0);
        table.put("F", 0);
        table.put("J", 0);
        table.put("M", 0);
        table.put("A", 0);
        table.put("N", 0);
        
        for (int i = 0; i < survey.length; i++) {
            String first = survey[i].substring(0, 1);
            String second = survey[i].substring(1, 2);
            
            int choice = choices[i];
            
            switch(choice) {
                case 1:
                case 2:
                case 3: {
                    table.put(first, table.get(first) + scores[choice]);
                    break;
                }
                case 5:
                case 6:
                case 7: {
                    table.put(second, table.get(second) + scores[choice]);
                    break;
                }
                default: {
                    
                }
            }
        }
        
        String answer = "";
        answer += (table.get("R") < table.get("T")) ? "T" : "R";
        answer += (table.get("C") < table.get("F")) ? "F" : "C";
        answer += (table.get("J") < table.get("M")) ? "M" : "J";
        answer += (table.get("A") < table.get("N")) ? "N" : "A";
        
        return answer;
    }
}