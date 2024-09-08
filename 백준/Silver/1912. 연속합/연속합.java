import java.util.*;
import java.io.*;

public class Main {
    static int[] arr ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 저장
        }

        int[] dp = new int[n]; // 합 배열
        dp[0] = arr[0];

        for (int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

        br.close();
    }
}
