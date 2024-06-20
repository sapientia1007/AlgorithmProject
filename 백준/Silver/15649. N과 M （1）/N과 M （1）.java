import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main{
	static int N = 0, M=0, C=0;
	static int[] arr;
	static int[] b ;
	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		b = new int[M];
		v =  new boolean[N];
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		
		C = 0;
		perm(0);
		System.out.println(sb);
		br.close();

	}

	
	static void perm(int cnt) {
		if (cnt == M) {
			for (int val: b) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;

		}
		for (int i=0; i<N; i++) {
			if(v[i]) continue; 
			v[i] = true;
			b[cnt] = arr[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
}
