import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정: 첫 번째 집의 비용 그대로 사용
        dp[0][0] = arr[0][0]; 
        dp[0][1] = arr[0][1]; 
        dp[0][2] = arr[0][2]; 

        for (int i=1; i<N; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));

        System.out.println(result);
        br.close();
    }
}
