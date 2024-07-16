import java.util.Arrays;

class Solution {
    // 2024 현대 오토에버 기출과 유사
    // 그리디, 정렬
    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> t1[0] - t2[0]);
        
        int answer = 1;
        int preS = targets[0][0];
        int preE = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];
            
            int curS = target[0];
            int curE = target[1];
            
            if (curS >= preS && curS < preE) {
                preS = Math.max(preS, curS);
                preE = Math.min(preE, curE);
            } else {
                preS = curS;
                preE = curE;
                answer++;
            }
        }
        
        return answer;
    }
}