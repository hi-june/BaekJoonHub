class Solution {
    public boolean solution(String s) {
        String numbers = "0123456789";
        
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!numbers.contains(s.substring(i, i + 1))) {
                return false;
            }
        }
        
        return true;
    }
}