import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();

        long pCount = s.chars()
                .filter(i -> i == 'P')
                .count();

        long yCount = s.chars()
                .filter(i -> i == 'Y')
                .count();

        return pCount == yCount;
    }
}