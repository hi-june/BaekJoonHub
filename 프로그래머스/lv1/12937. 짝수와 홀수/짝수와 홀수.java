class Solution {
    static final String ODD = "Odd";
    static final String EVEN = "Even";
    
    public String solution(int num) {
        if (num % 2 == 0) {
            return EVEN;
        }
        
        return ODD;
    }
}