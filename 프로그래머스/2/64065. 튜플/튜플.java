import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        
        List<String> tokens = new ArrayList<>();
        int idx = 0;
        
        while (idx < s.length()) {
            char c = s.charAt(idx);
            idx++;

            String token = "";
            while (s.charAt(idx) != '}') {
                token += s.charAt(idx);
                idx++;
            }
            tokens.add(token);

            idx += 2;
        }
        
        List<List<Integer>> nums = new ArrayList<>();
        for (String token : tokens) {
            nums.add(
                Arrays.stream(token.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList())
            );
        }
        
        if (nums.size() == 1) {
            return nums.get(0).stream().mapToInt(Integer::intValue).toArray();
        }
        
        // System.out.println(nums);
        Collections.sort(nums, (l1, l2) -> l1.size() - l2.size());
        // System.out.println(nums);
        
        int[] answer = new int[nums.size()];
        answer[0] = nums.get(0).get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            List<Integer> prev = new ArrayList<>(nums.get(i - 1));
            List<Integer> curr = new ArrayList<>(nums.get(i));
            
            curr.removeAll(prev);
            answer[i] = curr.get(0);
        }
        
        return answer;
    }
}