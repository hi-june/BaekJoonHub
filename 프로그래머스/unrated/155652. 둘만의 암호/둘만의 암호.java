class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String without = "";
        
        for (int i = 0; i < alphabet.length(); i++) {
            String ss = alphabet.substring(i, i+1);
            if (!skip.contains(ss)) {
                without += ss;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int idx = without.indexOf(s.substring(i, i+1));
            idx = (idx + index) % without.length();
            answer += without.substring(idx, idx + 1);
        }
        
        return answer;
    }
}