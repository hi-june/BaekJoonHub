class Solution {
    private final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        
        // 갈 수 없는 땅 표시
        for (int[] p : puddles) {
            map[p[1]][p[0]] = -1;
        }
        
        // 시작 점 표시
        map[1][1] = 1;
        
        // 최단 경로 표시하기(n: 행, m: 열)
        for (int col = 1; col < n + 1; col++) {
            for (int row = 1; row < m + 1; row++) {
                if (map[col][row] == -1) continue;
                
                if (map[col - 1][row] > 0) {    // 위쪽 칸
                    map[col][row] += map[col - 1][row] % MOD;
                }
                
                if (map[col][row - 1] > 0) {    // 왼쪽 칸
                    map[col][row] += map[col][row - 1] % MOD;
                }
            }
        }
        
        return map[n][m] % MOD;
    }
}