class Solution {
    static final char PLUS = '+';
    static final char MINUS = '-';
    
    public int solution(String s) {
        switch(s.charAt(0)) {
            case '-': {
                return (-1) * Integer.parseInt(s.substring(1, s.length()));
            }
            case '+': {
                return Integer.parseInt(s.substring(1, s.length()));
            }
            default: {
                return Integer.parseInt(s);
            }
        }
    }
}