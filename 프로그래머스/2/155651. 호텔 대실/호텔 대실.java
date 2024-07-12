import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 퇴장 시간이 작은 친구가 먼저 나와야 함
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        // 1. 입장 시간 순서대로 정렬
        // 2. heap을 이용하여 퇴장 시간과 입장 시간 비교
        Arrays.sort(book_time, (b1, b2) -> {
            if (b1[0].compareTo(b2[0]) == 0)
                return b2[1].compareTo(b1[1]);
                
            return b1[0].compareTo(b2[0]);
        });
            
        for (String[] b : book_time) {
            if (pq.isEmpty()) {
                pq.offer(b[1]);
                continue;
            }
            
            String availTime = getTime(pq.peek());
            String sTime = b[0];
            if (sTime.compareTo(availTime) < 0) {   // 겹치면
                pq.offer(b[1]);
            } else {
                pq.poll();
                pq.offer(b[1]);
            }
        }
        
        return pq.size();
    }
    
    private String getTime(String time) {
        String[] t = time.split(":");
        
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        
        m += 10;
        if (m >= 60) {
            h += 1;
            m -= 60;
        }
        
        return String.format(
            "%s:%s",
            (h < 10) ? "0" + h : Integer.toString(h),
            (m < 10) ? "0" + m : Integer.toString(m)
        );
    }
}