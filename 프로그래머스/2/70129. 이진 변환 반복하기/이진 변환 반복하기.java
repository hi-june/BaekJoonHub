import java.util.Stack;

class Solution {
    private static int binCount = 0;
    private static int zeroCount = 0;
    
    public int[] solution(String s) {        
        while (!s.equals("1")) {
            // 1. 0 변환
            int beforeLen = s.length();
            s = s.replace("0", "");
            
            int c = s.length();
            zeroCount += beforeLen - c;
            
            // 2. 2진법 변환
            s = getBinary(c);
            binCount++;
        }

        return new int[] {binCount, zeroCount}; // 이진 변환의 횟수, 변환 과정에서 제거된 모든 0의 개수
    }
    
    private String getBinary(int c) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        while (c / 2 != 0) {
            int remain = c % 2;            
            stack.push(remain);
            
            c = c / 2;
        }
        stack.push(c);
        
        while (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pop()));
        }
        
        return sb.toString();
    }
}