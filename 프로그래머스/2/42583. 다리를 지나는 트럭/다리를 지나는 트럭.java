import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        // init
        int curWeight = 0;
        int time = 0;
        
        int idx = 0;
        while (idx < truck_weights.length) {
            int truck = truck_weights[idx];
            
            if (bridge.isEmpty()) { // 다리가 비어 있는 경우
                bridge.offer(truck);
                curWeight += truck;
                
                idx++;
            } else {    // 다리에 트럭이 있는 경우
                if (bridge.size() == bridge_length) { // 꽉 찬 경우
                    curWeight -= bridge.poll();
                } 
                
                if (curWeight + truck > weight) {   // 무게 초과
                    bridge.offer(0);
                } else {
                    bridge.offer(truck);
                    curWeight += truck;
                    
                    idx++;
                }
            }
            
            time++;
        }
        
        return time + bridge_length;
    }
}