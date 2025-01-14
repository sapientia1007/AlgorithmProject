import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[] value = new int[N]; int[] weight = new int[N];
        
		for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); int v = Integer.parseInt(st.nextToken());
			weight[i] = w; value[i] = v;
		}

		int[] dp = new int[K+1];

		for(int i=0; i<N; i++){
			for (int j=K; j>=1; j--){
				if (weight[i]<=j){
					dp[j] = Math.max(dp[j], value[i]+dp[j-weight[i]]);
				}
			}
		}
		System.out.println(dp[K]);
        br.close();
	}
}
