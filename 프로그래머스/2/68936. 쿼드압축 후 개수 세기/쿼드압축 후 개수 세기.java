class Solution {
    private int zeroCount = 0;
    private int oneCount = 0;
    
    public int[] solution(int[][] arr) {
        int n = arr[0].length;
        
        quadTree(0, 0, arr, n);
        
        return new int[]{zeroCount, oneCount};
    }
    
    private void quadTree(int col, int row, int[][] arr, int size) {
        if (check(col, row, arr, size)) {
            switch (arr[col][row]) {
                case 0: {
                    zeroCount++;
                    return;
                }
                case 1: {
                    oneCount++;
                    return;
                }
            }
        }
        
        int newSize = size / 2;
        
        quadTree(col, row, arr, newSize);
        quadTree(col, row + newSize, arr, newSize);
        quadTree(col + newSize, row, arr, newSize);
        quadTree(col + newSize, row + newSize, arr, newSize);
    }
    
    private boolean check(int col, int row, int[][] arr, int size) {
        int target = arr[col][row];
        
        for (int i = col; i < col + size; i++) {
            for (int j = row; j < row + size; j++) {
                if (arr[i][j] != target) return false;
            }
        }
        
        return true;
    }
}