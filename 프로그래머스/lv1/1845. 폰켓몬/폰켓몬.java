import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        int pick = nums.length / 2;
        
        Set<Integer> pocketMon = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        
        if (pick <= pocketMon.size()) {
            return pick;
        }
        return pocketMon.size();
    }
}