class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] array = number.toCharArray();
        
        int startIdx = 0;
        for (int i = k; i < number.length(); i++) {
            
            char max = '0';
            for (int j = startIdx; j <= i; j++) {
                char num = array[j];
                
                if (num > max) {
                    max = num;
                    startIdx = j + 1;
                }
            }
            
            sb.append(String.valueOf(max));
        }
        
        return sb.toString();
    }
}