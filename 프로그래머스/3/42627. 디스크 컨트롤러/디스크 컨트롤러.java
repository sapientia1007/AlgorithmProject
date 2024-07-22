import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0; // 현재시간
        
        // 작업 요청 순으로 일단 jobs 정렬
        Arrays.sort(jobs, Comparator.comparingInt(job-> job[0]));

        // 우선순위 큐에 작업시간 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(o -> o[1])
        );

        int jobIdx = 0; // 현재 확인중인 job 인덱스
        int completedJobs = 0; // 완료된 작업 수

        while (completedJobs < jobs.length) {
            // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가 + 확인 idx++
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }

            if (pq.isEmpty()) { // 큐가 비어있으면, 다음작업으로
                currentTime = jobs[jobIdx][0];
            } else {
                // 가장 짧은 작업을 꺼내어 처리 
                int[] task = pq.poll();
                currentTime += task[1]; // 현재 시간 update
                answer += (currentTime - task[0]);
                completedJobs++;
            }
        }
        return answer / jobs.length;
    }
}