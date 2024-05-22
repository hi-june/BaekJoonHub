class Solution {
    public int solution(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
        int s = 0;
        int e = s;
        
        int total = nums[e];
        int count = 0;
        
        while (s <= e) {            
            if (total >= n) {
                if (total == n) count++;
                
                total -= nums[s];
                s++;
            } else if (total < n) {
                e++;
                total += nums[e];               
            } else {
                break;
            }
        }
        
        return count;
    }
}