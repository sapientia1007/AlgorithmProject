import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1; // 기본

            if (i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);

            if (i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[N]);

        while (N > 0) {
            result.add(N);

            if (N%3 == 0 && dp[N] == dp[N/3]+1) N/=3;
            else if (N%2 == 0 && dp[N] == dp[N/2]+1) N/=2;
            else N-=1;
        }

        for (int num : result) System.out.print(num + " ");
        br.close();
    }
}
