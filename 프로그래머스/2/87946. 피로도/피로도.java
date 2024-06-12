class Solution {
    private boolean[] visited;
    private int count;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, 0, k, dungeons);
        
        return count;
    }
    
    private void dfs(int depth, int cur, int k, int[][] dungeons) {
        count = Math.max(count, cur);
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            
            int[] dungeon = dungeons[i];
            
            if (k >= dungeon[0]) {
                visited[i] = true;
                dfs(depth + 1, cur + 1, k - dungeon[1], dungeons);
                visited[i] = false;
            }
        }
    }
}