import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int cnt = 0;
        for (int idx : dp) {
            cnt = Math.max(cnt, idx);
        }

        System.out.println(cnt);
        br.close();
    }
}
