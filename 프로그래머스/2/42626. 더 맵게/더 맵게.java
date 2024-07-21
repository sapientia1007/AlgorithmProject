import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s); // priorityqueue에 scoville 배열 담기
        }

        while (pq.size()>1 && pq.peek()<K){ // 2개 이상의 heap 배열이고, 첫번째 값이 K보다 작으면 -> 섞은 음식의 스코빌 지수 리턴
            int firstNum = pq.poll();
            int secondNum = pq.poll();
            int mixedScoville = firstNum + (secondNum*2);
            pq.add(mixedScoville);
            answer++;
        }

        if (pq.peek()<K) answer=-1; // 배열 값이 부족한데, 해당 첫번째값이 K보다 작으면, 스코빌 지수를 K이상으로 만들기 불가

        return answer;
    }
}