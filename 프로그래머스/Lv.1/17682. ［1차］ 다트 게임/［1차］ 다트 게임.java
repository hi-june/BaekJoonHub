import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // 3번
        // 점수: 0 ~ 10
        // 보너스: S, D, T
        // 옵션: *, #

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                if (dartResult.substring(i, i + 2).equals("10")) {  // check 10
                    nums.add(10);
                    i++;
                } else {
                    nums.add(Integer.valueOf(dartResult.substring(i, i + 1)));
                }
            } else if ("SDT".contains(dartResult.substring(i, i + 1))) {
                calculate(dartResult.substring(i, i + 1), nums);
            } else {
                bonus(dartResult.substring(i, i + 1), nums);
            }
        }

        return nums.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    static void calculate(String s, List<Integer> nums) {
        int idx = nums.size() - 1;
        int num = nums.get(idx);

        if (s.equals("S")) {
            nums.set(idx, (int) Math.pow(num, 1));
        } else if (s.equals("D")) {
            nums.set(idx, (int) Math.pow(num, 2));
        } else if (s.equals("T")) {
            nums.set(idx, (int) Math.pow(num, 3));
        }
    }

    static void bonus(String s, List<Integer> nums) {
        if (s.equals("*")) {
            if (nums.size() == 1) {
                nums.set(0, nums.get(0) * 2);
            } else {
                int idx1 = nums.size() - 2;
                int idx2 = nums.size() - 1;

                nums.set(idx1, nums.get(idx1) * 2);
                nums.set(idx2, nums.get(idx2) * 2);
            }
        } else if (s.equals("#")) {
            int idx = nums.size() - 1;
            nums.set(idx, nums.get(idx) * -1);
        }
    }
}