class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;

            answer = dfs(numbers, target, 0, 0);
            return answer;
        }
    
    public static int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, target, idx+1, sum + numbers[idx]) + dfs(numbers, target, idx+1, sum - numbers[idx]);
    }
    }