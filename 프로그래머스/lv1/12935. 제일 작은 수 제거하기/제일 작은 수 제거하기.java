import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        List<Integer> arrList = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        
        arrList.remove(Collections.min(arrList));
        
        return arrList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}