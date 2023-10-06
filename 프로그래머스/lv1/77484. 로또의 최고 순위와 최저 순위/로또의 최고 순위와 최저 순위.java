import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> lottosSet = Arrays.stream(lottos)
            .boxed()
            .collect(Collectors.toSet());
        
        Set<Integer> winNumsSet = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toSet());
        
        Set<Integer> inter = new HashSet<>(lottosSet);
        inter.retainAll(winNumsSet);
        
        int interCount = inter.size();
        int zeroCount = (int)Arrays.stream(lottos)
            .filter(l -> l == 0)
            .count();
        
        int minRank = (7 - interCount > 6) ? 6 : 7 - interCount;
        int maxRank = (7 - (interCount + zeroCount) > 6) ? 6 : 7 - (interCount + zeroCount);
        
        return new int[] {maxRank, minRank};
    }
}