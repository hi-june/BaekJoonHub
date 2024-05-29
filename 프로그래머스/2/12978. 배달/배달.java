import java.util.*;

class Solution {
    private static final int INF = 500_001;
    private int[][] map;
    private int[] mem;
    private boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {        
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                map[j][i] = INF;
            }
        }
        
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            
            map[from][to] = Math.min(map[from][to], weight);
            map[to][from] = Math.min(map[to][from], weight);
        }
        
        mem = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            mem[i] = map[1][i];
        }
        
        visited = new boolean[N + 1];
        visited[1] = true;
        
        for (int i = 1; i <= N - 1; i++) {
            int current = getMinIdx(N);
            visited[current] = true;
            
            for (int j = 2; j <= N; j++) {
                if (visited[j]) continue;
                
                if (mem[current] + map[current][j] < mem[j]) {
                    mem[j] = mem[current] + map[current][j];
                }
            }
        }
        
        return (int)Arrays.stream(mem).filter(i -> i <= K).count() + 1;
    }
    
    private int getMinIdx(int N) {
        int min = INF;
        int minIdx = 1;
        
        for (int i = minIdx; i <= N; i++) {
            if (!visited[i] && mem[i] < min) {
                min = mem[i];
                minIdx = i;
            }
        }
        
        return minIdx;
    }
}