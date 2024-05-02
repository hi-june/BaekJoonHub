class Solution {
    public int solution(int[][] triangle) {
        for (int col = triangle.length - 1; col >= 1; col--) {
            for (int row = 0; row < triangle[col].length - 1; row++) {
                triangle[col - 1][row] += Math.max(triangle[col][row], triangle[col][row + 1]);
            }
        }
        
        return triangle[0][0];
    }
}