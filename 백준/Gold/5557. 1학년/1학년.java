import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N+1][21]; // N개의 수를 더할거고, 0~20 숫자로 사용할 예정
        dp[0][arr[0]] = 1;

        for (int i=1; i<N; i++) {
            for (int j=0; j<=20; j++) {
                if (dp[i-1][j] != 0) {
                    int sum = j + arr[i];
                    int sub = j - arr[i];
                    if (0 <= sum && sum <= 20) dp[i][sum] += dp[i-1][j];
                    if (0 <= sub && sub <= 20) dp[i][sub] += dp[i-1][j];
                }
            }
        }
        
        System.out.println(dp[N-2][arr[N-1]]);

        br.close();
    }
}
