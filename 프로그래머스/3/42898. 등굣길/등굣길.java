class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] dp = new int[m][n];

            // 집의 위치 초기화(시작점 -> dp[m-1][n-1]까지 가야함)
            dp[0][0] = 1;

            // 웅덩이 위치 저장
            for (int[] p : puddles) {
                dp[p[0]-1][p[1]-1] = -1;
            }

            // 첫번째 행과 첫번째 열 초기화 (웅덩이가 아닌 경우, 왼쪽 셀/윗쪽 셀 값을 가져옴)
            for (int i=1; i<m; i++) dp[i][0] = (dp[i][0] == -1) ? 0 : dp[i-1][0];
            for (int i=1; i<n; i++) dp[0][i] = (dp[0][i] == -1) ? 0 : dp[0][i-1];

            // 나머지 셀 계산 => 웅덩이가 아닌 경우 위쪽 셀 + 왼쪽 셀
            for (int i=1; i<m; i++){
                for (int j=1; j<n; j++){
                    if (dp[i][j] == -1) dp[i][j] = 0; // 웅덩이
                    else dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                }
            }
            
            answer = dp[m-1][n-1];
            return answer;
        }
    }
