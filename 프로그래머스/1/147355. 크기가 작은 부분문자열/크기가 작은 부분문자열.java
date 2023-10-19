class Solution {
    public int solution(String t, String p) {
        StringBuilder sb = new StringBuilder(t);
        int answer = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String sub = sb.substring(i, i + p.length());
            
            if (Long.parseLong(p) >= Long.parseLong(sub)) {
                answer++;
            }
        }
        
        return answer;
    }
}