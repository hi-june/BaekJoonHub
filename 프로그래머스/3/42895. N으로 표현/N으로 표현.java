import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> nums = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            nums.put(i, new HashSet<>());
        }
        
        nums.get(1).add(N);
        
        for (int i = 2; i < 9; i++) {
            Set<Integer> set = nums.get(i);
            
            // 여러 경우의 수 조합
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = nums.get(j);
                Set<Integer> postSet = nums.get(i - j);
                
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        
                        if (postNum != 0) {
                            set.add(preNum / postNum);
                        }
                    }
                }
            }
            
            // i개의 N으로 이루어진 숫자 추가
            set.add(Integer.valueOf(Integer.toString(N).repeat(i)));
        }
        
        for (int k = 1; k < 9; k++) {
            Set<Integer> set = nums.get(k);
            
            if (set.contains(number)) return k;
        }
        
        return -1;
    }
}