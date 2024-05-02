import java.util.*;

class Solution {
    private static class Track implements Comparable<Track> {
        int num;
        int count;
        
        private Track(int num, int count) {
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Track t) {
            if (this.count == t.count) {
                return this.num - t.num;
            }
            
            return (this.count - t.count) * -1;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Track>> songs = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            PriorityQueue<Track> queue = songs.getOrDefault(genres[i], new PriorityQueue<>());
            
            queue.offer(new Track(i, plays[i]));
            songs.put(genres[i], queue);
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keyList = new ArrayList<>(count.keySet());
        Collections.sort(keyList, (k1, k2) -> count.get(k2) - count.get(k1));
        
        List<Integer> answer = new ArrayList<>();
        for (String key : keyList) {
            PriorityQueue<Track> pq = songs.get(key);
            
            int n = 0;
            while (!pq.isEmpty() && n < 2) {
                int num = pq.poll().num;
                answer.add(num);
                
                n++;
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}