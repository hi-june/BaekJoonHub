import java.util.*;

// 그리디: 뒤에 무엇이 올지 모르니 다섯 개 씩 그룹화하여 정렬한다.
class Solution {
    private final int[][] board = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };

    // 다이아, 철, 돌
    public int solution(int[] picks, String[] minerals) {
        int answer = 0; // 피로도

        int total = Arrays.stream(picks).sum();
        int len = Math.min(total, (int)Math.ceil((double)minerals.length / 5));
        
        // [index, tired]
        int[][] tired = new int[len][2];
        int idx = 0;
        for (int i = 0; i < minerals.length; i += 5) {
            if (idx >= len) break;
            
            tired[idx][0] = i;

            int acc = 0;
            for (int j = i; j < Math.min(i + 5, minerals.length); j++) {
                String mineral = minerals[j];

                if (mineral.equals("diamond")) {
                    acc += board[2][0];
                } else if (mineral.equals("iron")) {
                    acc += board[2][1];
                } else if (mineral.equals("stone")) {
                    acc += board[2][2];
                }
            }

            tired[idx][1] = acc;
            idx++;
        }

        // tired 내림차순 정렬
        Arrays.sort(tired, (t1, t2) -> t2[1] - t1[1]);

        for (int[] t : tired) {
            int pick = getPick(picks);

            if (pick == -1) break;

            int acc = 0;
            for (int i = t[0]; i < Math.min(t[0] + 5, minerals.length); i++) {
                String mineral = minerals[i];

                if (mineral.equals("diamond")) {
                    acc += board[pick][0];
                } else if (mineral.equals("iron")) {
                    acc += board[pick][1];
                } else if (mineral.equals("stone")) {
                    acc += board[pick][2];
                }
            }

            answer += acc;
            picks[pick] -= 1;
        }

        return answer;
    }

    private int getPick(int[] picks) {
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) return i;
        }

        return -1;
    }
}