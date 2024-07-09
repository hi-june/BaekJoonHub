class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int[] dRev = new int[deliveries.length];
        for (int i = deliveries.length - 1; i >= 0; i--) {
            dRev[deliveries.length - i - 1] = deliveries[i];
        }
        
        int[] pRev = new int[pickups.length];
        for (int i = pickups.length - 1; i >= 0; i--) {
            pRev[pickups.length - i - 1] = pickups[i];
        }
        
        long answer = 0;
        
        int deli = 0;
        int pick = 0;
        for (int i = 0; i < n; i++) {
            deli += dRev[i];
            pick += pRev[i];
            
            while (deli > 0 || pick > 0) {
                deli -= cap;
                pick -= cap;
                answer += (n - i) * 2;
            }
        }
        
        return answer;
    }
}