import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> acc = new HashMap<>();
        
        for (String record : records) {
            String[] inputs = record.split(" ");
            
            String timeStamp = inputs[0];
            String num = inputs[1];
            String cmd = inputs[2];
            
            switch (cmd) {
                case "IN": {
                    map.put(num, timeStamp);
                    acc.putIfAbsent(num, 0);
                    break;
                }
                case "OUT": {
                    int val = getTime(map.get(num), timeStamp);
                    
                    acc.replace(num, acc.get(num) + val);
                    map.remove(num);
                    break;
                }
            }
        }
        
        // 미출차 처리
        for (String num : map.keySet()) {
            String timeStamp = map.get(num);
            int val = acc.get(num);
            
            acc.replace(num, val + getTime(timeStamp, "23:59"));
        }
        
        // 답안 구성
        int[] answer = new int[acc.size()];
        List<String> keys = new ArrayList<>(acc.keySet());
        Collections.sort(keys);
        
        int idx = 0;
        for (String key : keys) {
            answer[idx++] = getFee(acc.get(key), fees);
        }
        
        return answer;
    }
    
    private static int getTime(String timeStamp, String endTime) {
        int startVal = Integer.parseInt(timeStamp.split(":")[0]) * 60 + Integer.parseInt(timeStamp.split(":")[1]);
        int endVal = Integer.parseInt(endTime.split(":")[0]) * 60 + Integer.parseInt(endTime.split(":")[1]);
        
        return endVal - startVal;
    }
    
    private static int getFee(int minute, int[] fees) {
        int defaultT = fees[0];
        int defaultPrice = fees[1];
        int t = fees[2];
        int cost = fees[3];
        
        if (minute <= defaultT) {
            return defaultPrice;
        }
        
        double target = (double)(minute - defaultT) / t;
        int val = ((minute - defaultT) % t != 0) ? (int)Math.ceil(target) : (minute - defaultT) / t;
        
        return defaultPrice + (val * cost);
    }
}