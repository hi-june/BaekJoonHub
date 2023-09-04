class Solution {
    public int solution(int num) {
        long numL = (long)num;
        int count = 0;
        
        while (numL > 1) {
            if (count >= 500) {
                return -1;
            }
            
            if (numL % 2 == 0) {
                numL = numL / 2;
            } else {
                numL = (numL * 3) + 1;
            }
            
            count += 1;
        }
        
        return count;
    }
}