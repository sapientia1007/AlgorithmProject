import java.io.*;
import java.util.*;

public class Main {
	static int N; 
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		dp = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i=2; i<41; i++) {
			for (int j=0; j<2; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-2][j];
			}
		}
		
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num][0] + " " +dp[num][1]);
		}
		br.close();
	}
}
