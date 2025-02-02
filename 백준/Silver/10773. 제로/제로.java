import java.io.*;
import java.util.*;

public class Main {
	static int K; static ArrayDeque<Integer> st; static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		st = new ArrayDeque<>();
		for (int i=0; i<K; i++) {
			int inputInteger=  Integer.parseInt(br.readLine());
			if (inputInteger == 0) {
				st.pop();
			} else {
				st.push(inputInteger);
			}
		}
		
		for (int s : st) {
			sum+=s;
		}
		System.out.println(sum);
		br.close();
	}
}
