class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for (long i = left; i <= right; i++) {
            long col = i / n;
            long row = i % n;
            
            answer[idx++] = (int)(Math.max(col, row) + 1);
        }
        
        return answer;
    }
}