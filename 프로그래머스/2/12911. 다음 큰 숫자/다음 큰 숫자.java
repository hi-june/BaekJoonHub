class Solution {
    private int oneCount = 0;
    
    public int solution(int n) {
        String nStr = Integer.toString(n, 2);
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == '1') oneCount++;
        }
        
        int target = n + 1;
        while (!isValid(target)) {
            target++;
        }
        
        return target;
    }
    
    private boolean isValid(int target) {
        String s = Integer.toString(target, 2);
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        
        return count == oneCount;
    }
}