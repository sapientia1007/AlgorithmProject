import java.io.*;
import java.util.*;
/*
 * 입력 : 
 * 		N : 컴퓨터의 수
 * 		M : 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
 * 		M개의 줄 - 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍
 * 출력 : 
 * 		1번 컴퓨터에 의해 바이러스가 걸리게 되는 컴퓨터의 수
 * 처리 : 
 * 		bfs 사용
 */
public class Main {
	static int N, M ;
	static List<Integer> [] g;
	static boolean[] v;
	static ArrayList<Integer> res = new ArrayList<>();
		
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while (!q.isEmpty()) {
			i = q.poll();
			res.add(i);
			for (int j : g[i]) {
				if (!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
		g = new List[N+1]; for (int i=1; i<N+1; i++) g[i] = new ArrayList<>();
		v = new boolean[N+1];
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		bfs(1);
		System.out.println(res.size()-1);
		br.close();
	}
}
