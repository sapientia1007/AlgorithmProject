import java.io.*;
import java.util.*;

public class Main{

	static int n, c;
	static int[] arr ;
	static boolean[] check ;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = new boolean[n];
		arr = new int[n];
		perm(0);
		System.out.println(sb);
		br.close();
	}
	
	static void perm(int cnt) {
		if (cnt == n) {
			for (int val:arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		} 
		for (int i=0; i<n; i++) {
			if (check[i]) continue;
			check[i] = true;
			arr[cnt]=i+1;
			perm(cnt+1);
			check[i] = false;
		}
	}
}
