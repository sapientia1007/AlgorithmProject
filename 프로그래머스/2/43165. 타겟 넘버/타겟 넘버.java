import java.util.*;
class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            // 결과를 담는 q -> BFS 방식 사용
            ArrayDeque<int[]> q = new ArrayDeque<>();

            // 일단 첫번째 값에 대해 +, - 결과 추가
            q.offer(new int[] {numbers[0], 0});
            q.offer(new int[] {-numbers[0], 0});

            // BFS 탐색
            while (!q.isEmpty()) {
                int[] current = q.poll();
                int sum = current[0];
                int curIdx = current[1];

                if (curIdx == numbers.length - 1) { // 마지막 검사를 했을때
                    if (sum == target) {
                        answer++;
                    }
                } else {
                    int nextIdx = curIdx + 1; // 다음 숫자에 대해 +, - 결과 추가
                    q.offer(new int[]{sum + numbers[nextIdx], nextIdx});
                    q.offer(new int[]{sum - numbers[nextIdx], nextIdx});
                }
            }

            return answer;
        }
    }
