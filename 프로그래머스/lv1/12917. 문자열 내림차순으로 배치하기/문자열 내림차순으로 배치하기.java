import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String[] sArray = s.split("");
        Arrays.sort(sArray, Comparator.reverseOrder());
        return String.join("", sArray);
        
        // return Arrays.stream(s.split(""))
        //         .sorted(Comparator.reverseOrder())
        //         .collect(Collectors.joining());
    }
}