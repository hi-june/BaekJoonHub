import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
        String strNum = String.valueOf(n);
        String[] strArr = strNum.split("");
        
        Arrays.sort(strArr, Comparator.reverseOrder());
        
        return Long.valueOf(String.join("", strArr));
    }
}