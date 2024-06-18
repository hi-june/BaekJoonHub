class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for (long n : numbers) {
            long num = n + 1;
            
            answer[idx++] = num + ((n ^ num) >> 2);
        }
        
        return answer;
    }
}