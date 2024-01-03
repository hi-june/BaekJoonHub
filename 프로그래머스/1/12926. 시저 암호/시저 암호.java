class Solution {
    static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isUpperCase(c)) {
                int idx = UPPER_CASE.indexOf(String.valueOf(c));
                int newIdx  = idx + n;
                sb.append(UPPER_CASE.charAt(newIdx % UPPER_CASE.length()));
            } else if (Character.isLowerCase(c)) {
                int idx = LOWER_CASE.indexOf(String.valueOf(c));
                int newIdx  = idx + n;
                sb.append(LOWER_CASE.charAt(newIdx % LOWER_CASE.length()));
            } else {
                sb.append(String.valueOf(c));
            }
        }
        
        return sb.toString();
    }
}