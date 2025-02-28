import java.io.*;
import java.util.*;

public class Main {
	static int N; static int M;
	static int[][] arr ; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		arr = new int[N][M]; 
		
		for (int i=0; i<N; i++) {
			String[] nums = br.readLine().split("");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(nums[j]);
			}
		}

		int minNumber = Math.min(N,M);
		while (minNumber > 1) {
			for (int i=0; i<N-minNumber+1; i++) {
				for (int j=0; j<M-minNumber+1; j++) {
					int num = arr[i][j];
					if (num == arr[i][j+minNumber-1] && 
						num == arr[i+minNumber-1][j] && 
						num == arr[i+minNumber-1][j+minNumber-1]) {
						System.out.println(minNumber * minNumber);
						return;
					}  
				}				
			}
			minNumber-=1;
		}   
		System.out.println(minNumber * minNumber);
		br.close();
	}
}
