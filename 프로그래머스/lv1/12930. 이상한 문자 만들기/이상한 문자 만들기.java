class Solution {
    public String solution(String s) {
        int idx = 0;
        String[] words = s.split("");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String c = words[i];
            
            if (c.equals(" ")) {
                idx = 0;
                sb.append(c);
                continue;
            }
            
            if (idx % 2 != 0) {   // 홀수인 경우
                sb.append(c.toLowerCase());
            } else {    // 짝수인 경우
                sb.append(c.toUpperCase());
            }
            idx += 1;
        }
        
        return sb.toString();
    }
}