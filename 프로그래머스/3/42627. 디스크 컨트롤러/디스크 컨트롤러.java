import java.util.*;

class Solution {
    private static class Job {
        public int start;
        public int duration;
        
        public Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        
        int idx = 0;
        for (int[] j : rawJobs) {
            jobs[idx++] = new Job(j[0], j[1]);
        }
        
        // 작업의 시작 시간을 기준으로 배열 정렬
        Arrays.sort(jobs, (j1, j2) -> j1.start - j2.start);
        
        // 모든 작업 순회를 위한 큐
        Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
        
        // 수행 시간이 짧은 순으로 큐에서 나오도록 설정(수행 시간이 짧은 걸 먼저 처리할 수록 대기 시간이 짧아지기 때문)
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> j1.duration - j2.duration);
        
        int exec = 0;   // 작업 시간(요청 부터 종료까지)의 누적합
        int time = 0;   // 현재 시간
        
        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().start <= time) {
                pq.offer(q.poll());
            }
            
            if (pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }
            
            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;
        }
        
        return exec / jobs.length;
    }
}