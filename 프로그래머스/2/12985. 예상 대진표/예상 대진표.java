class Solution {
    public int solution(int n, int a, int b) {
        a -= 1;
        b -= 1;
        
        int count = 0;
        while (true) {
            count++;
            
            if (a / 2 == b / 2) break;
            
            a /= 2;
            b /= 2;
        }

        return count;
    }
}