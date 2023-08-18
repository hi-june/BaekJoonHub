class Solution {
    public String solution(String s) {
        int len = s.length();
        int idx = len / 2;
        
        if (len % 2 != 0) {
            return s.substring(idx, idx + 1);
        }
        
        return s.substring(idx - 1, idx + 1);
    }
}