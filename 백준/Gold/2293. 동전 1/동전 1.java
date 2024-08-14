import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpt = br.readLine().split(" ");

        int n = Integer.parseInt(inpt[0]); int k = Integer.parseInt(inpt[1]);
        int[] val = new int[n];
        for (int i=0; i<n; i++) val[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[k+1]; dp[0]=1; // dp 선언 및 초기화
        
        for (int v: val){
            for (int i=v; i<=k; i++){
                dp[i] += dp[i-v];
            }
        }

        System.out.println(dp[k]);
        br.close();
    }
}
