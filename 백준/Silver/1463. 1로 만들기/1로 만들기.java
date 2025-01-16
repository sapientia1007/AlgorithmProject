import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정수 N

        int[] dp = new int[N+1];
        dp[1] = 0;

        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1; // 기본

            if (i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1); // 2로 나눠짐

            if (i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1); // 3으로 나눠짐
        }

        System.out.println(dp[N]);
        br.close();
    }
}
