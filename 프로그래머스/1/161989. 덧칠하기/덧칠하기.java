class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        
        int checkPoint = section[0] + m;
        for (int idx = 1; idx < section.length; idx++) {
            if (section[idx] < checkPoint) {
                continue;
            }
            
            checkPoint = section[idx] + m;
            count++;
        }
        
        return count;
    }
}