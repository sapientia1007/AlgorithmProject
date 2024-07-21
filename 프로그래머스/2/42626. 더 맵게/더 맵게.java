import java.util.*;

class Solution {
   public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.add(s);
        }

        while (heap.size()>1 && heap.peek()<K){
            int firstNum = heap.poll();
            int secondNum = heap.poll();
            int mixedScoville = firstNum + (secondNum*2);
            heap.add(mixedScoville);
            answer++;
        }

        if (heap.peek()<K) answer=-1;

        return answer;
    }
}