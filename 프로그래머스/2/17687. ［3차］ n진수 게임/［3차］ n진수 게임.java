import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        char[] records = new char[t * m];
        
        int num = 0;
        int idx = 0;
        
        while (idx < records.length) {
            String bin = Integer.toString(num++, n).toUpperCase();
            
            for (int i = 0; i < bin.length(); i++) {
                if (idx >= records.length) break;
                
                char c = bin.charAt(i);
                records[idx++] = c;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int s = p - 1;
        for (int i = 0; i < t; i++) {
            sb.append(Character.toString(records[s]));
            s += m;
        }
        
        return sb.toString();
    }
}