import java.io.*;
import java.util.*;

public class Main {
	static int N; static int[][] arr; static int cnt;
	static class Lec implements Comparable<Lec> {
		int start;
		int end;
		Lec(int start, int end) {
			this.start= start;
			this.end = end;
		}
        
		@Override
		public String toString() {
			return start + " " + end; 
		}
		@Override
		public int compareTo(Lec o) {
			if (this.start == o.start) {
				return this.end - o.end ; 
			} else {
				return this.start - o.start;
			}
		}
	}	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];		
		cnt = 0; Lec[] lectures = new Lec[N];
		int end =-1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			int st = Integer.parseInt(str[0]); int ed = Integer.parseInt(str[1]);
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
			lectures[i] = new Lec(st,ed);
		}
		Arrays.sort(lectures, (a1, a2) ->a1.start == a2.start? a1.end-a2.end : a1.start-a2.start);
		pq.offer(lectures[0].end);
		for (int i=1; i<N; i++) {
			if (pq.peek() <= lectures[i].start) {
				pq.poll();
			}
			pq.offer(lectures[i].end);
		}
		
		System.out.println(pq.size());
	}
}
