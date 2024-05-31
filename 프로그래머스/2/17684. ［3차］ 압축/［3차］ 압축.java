import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        int dicIdx = 1;
        Map<String, Integer> dic = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dic.put(Character.toString(c), dicIdx++);
        }

        int idx = 0;
        while (idx < msg.length()) {
            String str = "";
            
            while (idx < msg.length()) {
                if (!dic.containsKey(str + msg.charAt(idx))) {
                    break;
                } else {
                    str += msg.charAt(idx);
                }
                idx++;
            }
            answer.add(dic.get(str));

            // 다음 글자까지의 문자열을 사전에 추가
            if (idx < msg.length()) {
                dic.put(str + msg.charAt(idx), dicIdx++);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}