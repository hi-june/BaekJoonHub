import java.util.*;

class Solution {
    private static final int MONTH_DAYS = 28;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            
            termsMap.put(t[0], Integer.valueOf(t[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String p = privacies[i];
            String date = p.split(" ")[0];
            String policy = p.split(" ")[1];
            
            if (isExpired(today, date, termsMap.get(policy))) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private static boolean isExpired(String today, String date, int duration) {
        int[] todayArray = Arrays.stream(today.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] dateArray = Arrays.stream(date.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int tValue = (todayArray[0] * 12 * MONTH_DAYS) + (todayArray[1] * MONTH_DAYS) + todayArray[2];
        int dValue = (dateArray[0] * 12 * MONTH_DAYS) + (dateArray[1] * MONTH_DAYS) + dateArray[2];
        
        int cValue = duration * MONTH_DAYS;
        
        return (tValue - dValue) >= cValue;
    }
}