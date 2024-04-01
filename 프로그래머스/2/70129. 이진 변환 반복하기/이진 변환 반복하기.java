class Solution {
    public int[] solution(String s) {        
        int binCount = 0;
        int zeroCount = 0;
        
        while (!s.equals("1")) {
            // 1. 0 변환
            int zeros = getZeroCount(s);
            int c = s.length() - zeros;
            zeroCount += zeros;
            
            // 2. 2진법 변환
            s = Integer.toString(c, 2);
            binCount++;
        }

        return new int[] {binCount, zeroCount}; // 이진 변환의 횟수, 변환 과정에서 제거된 모든 0의 개수
    }
    
    private int getZeroCount(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        
        return count;
    }
}