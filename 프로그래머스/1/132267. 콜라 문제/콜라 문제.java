class Solution {
    public int solution(int a, int b, int n) {
        // 빈 병 a개를 가져다주면 콜라 b병을 줌
        // 현재 빈 병의 수: n
        int cokeCount = 0;
        
        while (n >= a) {
            int remain = n % a;
            int coke = (n / a) * b;
            
            cokeCount += coke;
            n = coke + remain;
        }
        
        return cokeCount;
    }
}