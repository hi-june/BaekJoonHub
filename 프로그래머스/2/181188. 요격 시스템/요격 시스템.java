import java.util.*;

// 2024 현대 오토에버 기출과 유사
class Solution {
    public int solution(int[][] targets) {
        // [[1,4], [3,7], [4,5], [4,8], [5,12], [10,14], [11,13]]
        Arrays.sort(targets, (t1, t2) -> t1[0] - t2[0]);
        
        int answer = 0;        
        int preStart = targets[0][0];   // 1
        int preEnd = targets[0][1]; // 4

        for (int[] target : targets) {
            if (answer == 0) {
                answer += 1;
                continue;
            }
            
            int curStart = target[0];
            int curEnd = target[1];
            
            if (preStart <= curStart && curStart < preEnd) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                preStart = curStart;
                preEnd = curEnd;
                answer += 1;
            }
        }
    
        return answer;
    }
}