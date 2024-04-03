import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 0 1 3 5
        // Arrays.sort(citations);
        
//         int h = 0;
//         for (int i = 0; i < citations.length; i++) {
//             if () {
                
//             }
//         }
        int h = 0;
        
        while (h <= 10000) {
            int H = h;
            int count = (int)Arrays.stream(citations)
                .filter(c -> c >= H)
                .count();
            
            if (count < h) {
                return h - 1;
            }
            
            h++;
        }
        
        return h;
    }
}