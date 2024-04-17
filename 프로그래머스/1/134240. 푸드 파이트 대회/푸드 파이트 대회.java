import java.util.*;
import java.util.stream.*;

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
        
        String[] halfArray = halfAnswer.toString().split("");
        Arrays.sort(halfArray, Comparator.reverseOrder());
        
        return halfAnswer + "0" + String.join("", halfArray);
    }
}