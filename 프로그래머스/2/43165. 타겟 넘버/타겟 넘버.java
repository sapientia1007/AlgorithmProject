class Solution {
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            answer = 0;
            dfs(numbers,target,0,0);
            return answer;
        }

        public void dfs(int[] numbers, int target, int idx, int sum) { // 모든 경우를 탐색하기 위한 dfs
            if (idx == numbers.length){ // numbers 배열 끝에 인덱스가 도달했으면
                if (target == sum) answer++; // 협재 합이 타겟과 일치하면 경우의 수 증가 
                return; // 탐색 종료
            }
            dfs(numbers, target, idx+1, sum+numbers[idx]); // 현재 수 더하기
            dfs(numbers, target, idx+1, sum-numbers[idx]); // 현재 수 뺴기
        }
    }
