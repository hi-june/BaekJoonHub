import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
            .filter(n -> n % divisor == 0)
            .toArray();
        
        if (answer.length == 0) {
            int[] noElement = {-1};
            return noElement;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}