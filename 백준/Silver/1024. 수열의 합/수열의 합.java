import java.util.*;
import java.io.*;

public class Main {
	static int N; static int L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		while(true) {
			int min = N/L - ((L-1)/2); // 리스트의 첫번째 숫자 찾기
			if(min < 0 || L > 100) {
				System.out.println(-1);
				System.exit(0);
			}

			int sum = (min*2+L-1)*L/2; // 수열 합

			if(sum == N) {
				for (int i = 0; i < L; i++) {
					System.out.print((min+i) + " ");
				}
				System.exit(0);
			}

			L++;

		}
	}
}