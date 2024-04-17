import java.util.*;

class Solution {
    public String solution(int[] food) {
        int[] count = new int[food.length];
        
        count[0] = food[0];
        for (int i = 1; i < count.length; i++) {
            count[i] = food[i] / 2;
        }
        
        
        StringBuilder halfAnswer = new StringBuilder();
        for (int i = 1; i < count.length; i++) {
            halfAnswer.append(Integer.toString(i).repeat(count[i]));
        }
        
        return halfAnswer.toString() + "0" + halfAnswer.reverse().toString();
    }
}