import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        
        for (int h = len; h >= 1; h--) {
            int targetNum = citations[len - h];
            
            if (targetNum >= h) {
                return h;
            }
        }
        
        return 0;
    }
}