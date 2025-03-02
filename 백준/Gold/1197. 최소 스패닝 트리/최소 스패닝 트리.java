import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
		List<int[]>[] g = new List[V]; for (int i=0; i<V; i++) g[i] = new ArrayList<>();
		for (int e=0; e<E; e++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int A = Integer.parseInt(st.nextToken()) - 1; 
		    int B = Integer.parseInt(st.nextToken()) - 1; 
		    int C = Integer.parseInt(st.nextToken());
		    
		    g[A].add(new int[] {B, C});
		    g[B].add(new int[] {A, C});
		}
		
		boolean[] v = new boolean[V];
		int[] w = new int[V];
		
		for (int i=0; i<V; i++) w[i] = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1], o2[1]));
		int sum=0, cnt=0;
		w[0] =0;
		pq.offer(new int[] {0, 0});
		while(!pq.isEmpty()) {
			int[] vw = pq.poll();
			int min = vw[1];
			int minVertex = vw[0];
			if (v[minVertex]) continue;
			
			v[minVertex] = true;
			sum += min;
			if (cnt++ == V-1) break;
			
			for (int[] j : g[minVertex]) {
				if (!v[j[0]] && w[j[0]]>j[1]) {
					w[j[0]] = j[1];
					pq.offer(j);
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}
