class Solution {
    public String solution(int n) {
        String[] waterMelon = {"수", "박"};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(waterMelon[i % waterMelon.length]);
        }
        
        return sb.toString();
    }
}