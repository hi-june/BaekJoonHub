class Solution {
    public boolean solution(int x) {
        String[] numStrs = String.valueOf(x).split("");
        
        int total = 0;
        for (String s : numStrs) {
            total += Integer.valueOf(s);
        }
        
        return x % total == 0;
    }
}