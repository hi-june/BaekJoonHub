class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, -1}};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int value = 1;
        int col = 0;
        int row = 0;
        int d = 0;

        while (true) {
            triangle[col][row] = value++;

            int newCol = col + directions[d][0];
            int newRow = row + directions[d][1];

            // 처음으로 막혔다면
            if (newCol == n || newRow == n || newCol == -1 || newRow == -1 || triangle[newCol][newRow] != 0) {
                d = (d + 1) % directions.length;    // 방향 전환

                newCol = col + directions[d][0];
                newRow = row + directions[d][1];

                // 방향 전환했는데도 막힌다면
                if (newCol == n || newRow == n || newCol == -1 || newRow == -1 || triangle[newCol][newRow] != 0) break;
            }
            col = newCol;
            row = newRow;
        }

        int[] result = new int[value - 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[idx++] = triangle[i][j];
            }
        }

        return result;
    }
}