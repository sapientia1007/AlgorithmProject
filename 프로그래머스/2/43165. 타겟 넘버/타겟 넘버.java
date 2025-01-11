import java.util.ArrayDeque;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        // 모든 경우를 탐색
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
        public static int dfs(int[] numbers, int target, int idx, int sum) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int answer = 0;
        q.offer(new int[] {idx, sum});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int num = current[0]; int result = current[1];

            if (num == numbers.length) {
                if (result == target) answer ++;
            } else {
                q.offer(new int[] {num+1, result + numbers[num]});
                q.offer(new int[] {num+1, result - numbers[num]});
            }
        }
        return answer;
    }
}

