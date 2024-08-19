class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            // dp 배열 삼각형 높이만큼 생성
            int[] dp = new int[triangle.length];

            // 일단 맨 위 꼭대기는 포함
            dp[0] = triangle[0][0];

            // 삼각형 순회하면서 dp 배열 갱신
            for (int i = 1; i < triangle.length; i++) {
                for (int j=i; j>=0; j--) { // 오른쪽부터 순회
                    if (j == i) { // 가장 오른쪽 요소일떄
                        dp[j] = dp[j-1] + triangle[i][j]; // 이전 레벨의 바로 위쪽 요소 + 현재 요소
                    }
                    else if (j == 0) { // 가장 왼쪽 요소일떄
                        // 이전 레벨에서 바로 위의 요소만 고려 가능
                        dp[j] = dp[j] + triangle[i][j]; // 이전 레벨의 바로 위쪽 요소 + 현재 요소
                    } else {
                        dp[j] = Math.max(dp[j-1], dp[j]) + triangle[i][j]; // 중간 요소일때는 이전 레벨의 왼쪽 오른쪽 값 비교
                    }
                }
            }

            for (int i=0; i<dp.length; i++) answer = Math.max(answer,dp[i]);

            return answer;
        }
    }
