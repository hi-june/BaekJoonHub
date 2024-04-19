class Solution {
    public int solution(String s) {
        int strCount = 0;
        
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            
            int targetCount = 1;
            int compCount = 0;
            
            while (targetCount != compCount && idx < s.length() - 1) {
                idx++;
                
                char comp = s.charAt(idx);
                if (c == comp) {
                    targetCount++;
                } else {
                    compCount++;
                }
            }
            strCount++;
            idx++;
        }
        
        return strCount;
    }
}