import java.util.*;

class Solution {
    public int solution(int storey) {
        String str = Integer.toString(storey);
        int[] nums = Arrays.stream(str.split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == 5) {
                if (nums[i - 1] >= 5) {
                    nums[i - 1] += 1;
                    count += 10 - nums[i];
                } else {
                    count += nums[i];
                }
            } else if (nums[i] > 5) {
                nums[i - 1] += 1;
                count += 10 - nums[i];
            } else {
                count += nums[i];
            }
        }
        
        return (nums[0] > 5) ? count + 10 - nums[0] + 1 : count + nums[0];
    }
}