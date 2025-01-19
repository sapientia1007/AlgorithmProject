import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t; P[i]= p;
        }

        for (int i=1; i<=N; i++) {
            dp[i+1] = Math.max(dp[i],dp[i+1]);
            
            if (i + T[i] -1 <= N) {
                dp[i + T[i]] = Math.max(dp[i+T[i]], dp[i] +  P[i]);
            }
        }
        
        System.out.println(dp[N+1]);
        br.close();
    }
}
