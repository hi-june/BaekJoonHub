import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (p1, p2) -> p1[1].compareTo(p2[1]));

        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < plans.length - 1; i++) {
            map.put(plans[i][0], Integer.valueOf(plans[i][2]));

            int diff = getDiff(plans[i + 1][1], plans[i][1]);
            if (Integer.parseInt(plans[i][2]) > diff) {   // 더 오래 걸림
                map.put(plans[i][0], map.get(plans[i][0]) - diff);
                stack.push(plans[i][0]);
            } else if (Integer.parseInt(plans[i][2]) == diff) {
                map.remove(plans[i][0]);
                answer.add(plans[i][0]);
            } else {    // 넉넉함
                map.remove(plans[i][0]);
                answer.add(plans[i][0]);
                diff -= Integer.parseInt(plans[i][2]);

                while (!stack.isEmpty() && diff > 0) {
                    if (map.get(stack.peek()) > diff) {
                        map.put(stack.peek(), map.get(stack.peek()) - diff);
                        diff = 0;
                    } else {
                        diff -= map.get(stack.peek());
                        answer.add(stack.peek());
                        map.remove(stack.pop());
                    }
                }
            }
        }

        answer.add(plans[plans.length - 1][0]);
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }

        return answer.toArray(String[]::new);
    }

    private int getDiff(String after, String before) {
        int aH = Integer.parseInt(after.split(":")[0]);
        int aM = Integer.parseInt(after.split(":")[1]);

        int bH = Integer.parseInt(before.split(":")[0]);
        int bM = Integer.parseInt(before.split(":")[1]);

        return ((aH * 60) + aM) - ((bH * 60) + bM);
    }
}