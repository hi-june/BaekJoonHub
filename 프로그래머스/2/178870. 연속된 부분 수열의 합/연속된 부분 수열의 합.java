class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int[] answer = new int[2];
        
        int s = 0;
        int e = s;
        int total = sequence[0];
        
        while (s <= e) {
            if (total > k) {
                total -= sequence[s++];
            } else if (total < k) {
                if (e == sequence.length - 1) break;
                
                total += sequence[++e];
            } else {
                if (e - s < len) {
                    len = e - s;
                    answer[0] = s;
                    answer[1] = e;
                }
                
                if (e == sequence.length - 1) break;
                total += sequence[++e];
            }
        }
        
        return answer;
    }
}