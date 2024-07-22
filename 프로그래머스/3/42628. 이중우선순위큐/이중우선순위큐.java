import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작은 순 -> 큰 순
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder()); // 큰 순 -> 작은 순
        for (String inpt : operations) {
            String command = inpt.split(" ")[0];
            int num = Integer.parseInt(inpt.split(" ")[1]);
            if (command.equals("I")) {
                pq.offer(num);
                maxPq.offer(num);
            } else if (command.equals("D")) {
                if (num < 0 && !pq.isEmpty()) {
                    // 최솟값 삭제
                    int minValue = pq.poll();
                    maxPq.remove(minValue);
                } else if (num > 0 && !maxPq.isEmpty()) {
                    // 최댓값 삭제
                    int maxValue = maxPq.poll();
                    pq.remove(maxValue);
                }
            }
        }

        if (!pq.isEmpty() && !maxPq.isEmpty()) {
            answer[0] = maxPq.peek();
            answer[1] = pq.peek();
        } else {
            answer[0] = 0; answer[1] = 0;
        }
        return answer;
    }
}
