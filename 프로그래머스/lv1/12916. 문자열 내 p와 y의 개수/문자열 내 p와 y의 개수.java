import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();

        long pCount = Arrays.stream(s.split(""))
                .filter(i -> i.equals("P"))
                .count();

        long yCount = Arrays.stream(s.split(""))
                .filter(i -> i.equals("Y"))
                .count();

        return pCount == yCount;
    }
}