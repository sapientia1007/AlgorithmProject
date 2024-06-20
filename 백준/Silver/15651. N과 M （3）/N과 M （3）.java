import java.io.*;
import java.util.*;

public class Main {
	static int n, m, c;
	static int[] arr, save;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		arr = new int[n]; 
		save = new int[m]; 
		c=0;
	
		for (int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		perm(0);
		System.out.println(sb);
		
		br.close();

	}
	
	static void perm(int cnt) {
		if (cnt==m) {
			for (int k : save) {
				sb.append(k).append(" ");
			} sb.append("\n");
			c++;
			return;
		}
		for (int j=0; j<n; j++) {
			save[cnt] = arr[j];
			perm(cnt+1);
		} 
	}

}
