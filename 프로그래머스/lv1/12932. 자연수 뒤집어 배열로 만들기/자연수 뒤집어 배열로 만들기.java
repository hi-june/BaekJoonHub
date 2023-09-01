class Solution {
    public int[] solution(long n) {
        String strN = String.valueOf(n);
        int[] nums = new int[strN.length()];
        
        for (int i = 0; i < strN.length(); i++) {
            nums[i] = Integer.parseInt(strN.substring(strN.length() - i - 1, strN.length() - i));
        }
        
        return nums;
    }
}