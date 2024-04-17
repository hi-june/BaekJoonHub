import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] food) {
        int[] count = new int[food.length];
        
        count[0] = food[0];
        for (int i = 1; i < count.length; i++) {
            count[i] = food[i] / 2;
        }
        
        
        String halfAnswer = "";
        for (int i = 1; i < count.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < count[i]; j++) {
                sb.append(Integer.toString(i));
            }
            halfAnswer += sb.toString();
        }
        
        String[] halfArray = halfAnswer.split("");
        Arrays.sort(halfArray, Comparator.reverseOrder());
        
        return halfAnswer + "0" + String.join("", halfArray);
    }
}