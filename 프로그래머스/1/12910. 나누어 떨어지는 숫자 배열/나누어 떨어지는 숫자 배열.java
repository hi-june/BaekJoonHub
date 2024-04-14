import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> nums = new ArrayList<>();
        
        for (int idx = 0; idx < arr.length; idx++) {
            int n = arr[idx];
            
            if (n % divisor == 0) { // n이 divisor로 나누어 떨어지면
                // nums 리스트에 n을 추가
                nums.add(n);
            }
        }
        
        if (nums.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[nums.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nums.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}