import java.util.*;
import java.io.*;

public class Main {
	static int [] arr; static int MIN=Integer.MAX_VALUE; static int total=0;
	static PriorityQueue<Integer> pq ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		while (pq.size()>1) {
			int tmp1 = pq.poll();
			int tmp2 = pq.poll();

			total += tmp1+tmp2;
			pq.offer(tmp1+tmp2);
		}
		System.out.println(total);
	}
}
