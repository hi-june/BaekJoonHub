class Solution {
    private static final String[] nums = {"4", "1", "2"};
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            int remain = n % 3;
            sb.append(nums[remain]);
            
            if (remain == 0) {
                n = (n / 3) - 1;
            } else {
                n = n / 3;
            }
        }
        
        return sb.reverse().toString();
    }
}