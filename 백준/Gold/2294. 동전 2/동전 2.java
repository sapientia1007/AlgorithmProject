import java.util.*;
import java.io.*;

/*
* n, k -> n가지 종류의 동전 => 가치의 합이 k원이 되도록
* n개의 줄에는 각각의 동전의 가치
*  */
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inptLine = br.readLine();
        int n = Integer.parseInt(inptLine.split(" ")[0]); int k = Integer.parseInt(inptLine.split(" " )[1]);
        // 동전 가치를 담은 배열
        int[] coinsArr = new int[n];
        for (int i=0; i<n; i++){
            coinsArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coinsArr);

        // idx 동전 개수 배열
        Integer[] dp = new Integer[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE); dp[0]=0; // 초기화
        
        // dp 처리
        for (int i=0; i< dp.length; i++){
            for (int coin : coinsArr) {
                if (i>=coin && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
        br.close();
        
    } 
}
