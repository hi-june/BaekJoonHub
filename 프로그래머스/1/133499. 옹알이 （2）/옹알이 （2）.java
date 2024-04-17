class Solution {
    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for (String b : babbling) {
            if (b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) {
                continue;
            }
            
            for (String w : word) {
                b = b.replace(w, " ");
            }
            b = b.replace(" ", "");
            
            if (b.length() == 0) count++;
        }
        
        return count;
    }
}