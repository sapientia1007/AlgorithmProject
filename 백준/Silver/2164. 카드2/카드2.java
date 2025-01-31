import java.io.*;
import java.util.*;

public class Main {
	static int N; static ArrayDeque<Integer> q ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new ArrayDeque<>();
        
		for (int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while (q.size() > 1) {
			q.poll();
			q.offer(q.poll());

			if (q.size()==1) {
				System.out.println(q.peek());
				return;
			}
		}
        
		if (q.size() ==1) {
			System.out.println(q.peek());
		}
        
		br.close();
	}

}
