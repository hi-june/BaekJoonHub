import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> nums = new HashMap<>();
        
        for (int i = 2; i < 9; i++) {
            nums.put(i, new HashSet<>());
        }
        
        nums.put(1, Set.of(N));
        
        for (int i = 2; i < 9; i++) {
            Set<Integer> set = nums.get(i);
            
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = nums.get(j);
                Set<Integer> postSet = nums.get(i - j);
                
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if (postNum != 0) set.add(preNum / postNum);
                    }
                }
            }
            
            set.add(Integer.valueOf(Integer.toString(N).repeat(i)));
        }
        
        for (int k = 1; k < 9; k++) {
            if (nums.get(k).contains(number)) return k;
        }
        
        return -1;
    }
}