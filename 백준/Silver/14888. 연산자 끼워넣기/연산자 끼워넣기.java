import java.io.*;
import java.util.*;

public class Main {
	static int[] arr ;
	static int[] sign=new int[4];
	static int n ;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		
		arr = new int[n]; // 수 저장 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0;i<4;i++) {
			sign[i] = Integer.parseInt(st.nextToken()); // 연산자 저장
		}

		res(arr[0],1);
		System.out.println(MAX); System.out.println(MIN);
				
		br.close();

	}
	static void res(int num, int idx) {
		// if (ddd) return => 백트래킹?
		if (idx == n) { // 루프 종료 조건
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for (int i=0; i<4; i++) {
			if (sign[i] > 0) {
				sign[i]--;
				switch(i) {
					case 0:
						res(num+arr[idx], idx+1);
						break;
					case 1:
						res(num-arr[idx], idx+1);
						break;
					case 2:
						res(num*arr[idx], idx+1);
						break;
					case 3:
						res(num/arr[idx], idx+1);
						break;
				}
				sign[i]++;
			}
		}
	}	
}