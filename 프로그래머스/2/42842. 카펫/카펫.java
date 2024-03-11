class Solution {
    public int[] solution(int brown, int yellow) {
        int maxWidth = (5000 - 2) / 2;
        
        for (int w = 3; w <= maxWidth; w++) {
            for (int h = 3; h <= w; h++) {
                int b = 2 * (w + h) - 4;
                int y = (w - 2) * (h - 2);
                
                if (b == brown && y == yellow) {
                    return new int[] {w, h};
                }
            }
        }
        
        return null;
    }
}