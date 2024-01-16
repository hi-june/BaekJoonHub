import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostSet = new ArrayList<>();// new HashSet<>();
        List<Integer> reserveSet = Arrays.stream(reserve)
            .boxed()
            .collect(Collectors.toList());

        for (int i : lost) {
            Integer l = Integer.valueOf(i);
            if (reserveSet.contains(l)) {
                reserveSet.remove(l);
            } else {
                lostSet.add(l);
            }
        }

        Collections.sort(reserveSet);
        for (Integer i : reserveSet) {
            Integer l = i - 1;
            Integer r = i + 1;
            
            if (lostSet.contains(l)) {
                lostSet.remove(l);
            } else if (lostSet.contains(r)) {
                lostSet.remove(r);
            }
        }

        return n - lostSet.size();
    }
}