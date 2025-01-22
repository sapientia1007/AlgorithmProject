import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];

        int MOD = 1000000000;

        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            for (int j=0; j<=9; j++) {
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD; 
                if (j < 9) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MOD;
            }
        }

        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
            result %= MOD;
        }

        System.out.println(result);
        br.close();
    }
}
