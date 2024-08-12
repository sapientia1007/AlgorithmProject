import java.util.*;

class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int p : people) q.offer(p);

            while (q.size()>1) {
                if (q.peekFirst()+q.peekLast() <= limit) {
                    q.pollFirst();
                }
                q.pollLast();
                answer ++;

                if (q.size() == 1) answer += 1;
            }
            return answer;
        }
    }