public class Solution {
    public int solution(int n) {

        return getMinVal(n);
    }
    
    private int getMinVal(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        
        if (n % 2 == 0) {
            return getMinVal(n / 2);
        } else {
            return getMinVal(n / 2) + 1;
        }
    }
}