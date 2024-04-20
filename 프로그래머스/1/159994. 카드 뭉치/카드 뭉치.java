import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> cardStack1 = new Stack<>();
        Stack<String> cardStack2 = new Stack<>();
        
        for (int i = cards1.length - 1; i >= 0; i--) {
            cardStack1.push(cards1[i]);
        }
        
        for (int i = cards2.length - 1; i >= 0; i--) {
            cardStack2.push(cards2[i]);
        }
        
        for (String g : goal) {
            if (!cardStack1.isEmpty() && cardStack1.peek().equals(g)) {
                cardStack1.pop();
                continue;
            }
            
            if (!cardStack2.isEmpty() && cardStack2.peek().equals(g)) {
                cardStack2.pop();
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}