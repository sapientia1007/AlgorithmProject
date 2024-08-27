import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1]; // dp 배열 선언

        // 초기화 - dp 배열 크기에 따라 조건 필요
        if (n>=1) dp[1] = 1;
        if (n>=2) dp[2] = 3;
        
        // dp 배열 저장
        for (int i=3; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10_007;
        }
        System.out.println(dp[n]);
        br.close();
    }
}
