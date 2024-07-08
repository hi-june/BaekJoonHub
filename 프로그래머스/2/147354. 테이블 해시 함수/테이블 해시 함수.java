import java.util.*;

// 2024 상반기 PTKorea 기출
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (t1, t2) -> {
            if (t1[col - 1] == t2[col - 1]) {
                return t2[0] - t1[0];
            }
            
            return t1[col - 1] - t2[col - 1];
        });
        
        int SI = 0;
        int[] S = new int[row_end - row_begin + 1];
        for (int i = row_begin; i <= row_end; i++) {
            int idx = i - 1;
            int result = 0;
            
            for (int d : data[idx]) {
                result += d % i;
            }
            S[SI++] = result;
        }
        
        int answer = S[0];
        for (int i = 1; i < S.length; i++) {
            answer = answer ^ S[i];
        }
        
        return answer;
    }
}