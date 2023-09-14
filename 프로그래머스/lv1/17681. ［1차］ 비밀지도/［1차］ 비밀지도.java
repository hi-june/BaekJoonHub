import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // arr1과 arr2를 이진수 배열로 변환
        String[] tArr1 = new String[n];
        String[] tArr2 = new String[n];
        
        for (int i = 0; i < n; i++) {
            tArr1[i] = getDigit(arr1[i], n);
            tArr2[i] = getDigit(arr2[i], n);
        }
        // System.out.println(getDigit(0, n));
        // arr1과 arr2를 OR 연산
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = getCode(tArr1[i], tArr2[i], n);
        }
        
        return answer;
    }
    
    static String getDigit(int n, int size) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        if (n == 0) {
            while (sb.length() < size) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }
        
        while ((int)(n / 2) != 0) {
            stack.push(n % 2);
            n = (int)(n / 2);
        }
        sb.append("1");
        
        while (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pop()));
        }
        
        while (sb.length() < size) {
            sb.insert(0, "0");
        }
        
        return sb.toString();
    }
    
    static String getCode(String s1, String s2, int size) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            if (s1.substring(i, i + 1).equals("0") && s2.substring(i, i + 1).equals("0")) {
                sb.append(" ");
            } else {
                sb.append("#");
            }
        }
        
        return sb.toString();
    }
}