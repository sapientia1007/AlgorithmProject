import java.io.*;
import java.util.*;
/*
입력 :
	N : 물품의 수 / K : 준서가 버틸 수 있는 무게
	N개의 줄 -> 각 물건의 무게 W / 해당 물건 가치 V
출력 :
	한 줄에 배낭에 넣을 수 있는 물건들의 가치합 최대값
 */
public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N]; int[] value = new int[N];

		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
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
	}
}
