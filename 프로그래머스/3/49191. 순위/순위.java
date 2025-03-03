class Solution {
        static int[][] g;
        public int solution(int n, int[][] results) {
            int answer = 0;

            g = new int[n+1][n+1];
            for (int i=0; i<results.length; i++) {
                int winner = results[i][0];
                int loser = results[i][1];
                g[winner][loser] = 1;
            }

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    for (int k=1; k<=n; k++) {
                        if (g[j][i] == 1 && g[i][k] == 1) g[j][k] = 1;
                    }
                }
            }

            for (int i=1; i<=n; i++){
                int game = 0;
                for (int j=1; j<=n ;j++) {
                    if (g[i][j] == 1 || g[j][i] == 1) {
                        game ++;
                    }
                }
                if (game == n-1) {
                    answer ++;
                }
            }

            return answer;
        }
}