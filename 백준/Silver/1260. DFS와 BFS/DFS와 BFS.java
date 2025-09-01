import java.io.*;
import java.util.*;

/*
 입력 : 
 	N = 정점 개수
 	M = 간선 개수
 	V = 탐색 시작할 정점 번호
 	M개의 줄 => 간선이 연결하는 두 정점의 번호 => 양방향
 출력 : 
 	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
 처리 :
 	정점 번호가 작은것부터 방문/더 이상 방문할 수 없으면 종료
 	정점 번호 1~N
 */
public class Main {
	static int N, M, V;
	static List<Integer>[] g;
	static boolean[] v;
	
	static void dfs(int i) {
		v[i] = true;
		System.out.print(i+ " ");
		for (int j : g[i]) {
			if (!v[j]) dfs(j);
		}
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[i] = true;
		q.offer(i);
		while(!q.isEmpty()) {
			i = q.poll();
			System.out.print(i+ " ");
			for (int j:g[i]) {
				if(!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); V = Integer.parseInt(st.nextToken());
		g = new List[N+1]; v = new boolean[N+1];
		for (int i=1; i<N+1; i++) g[i] = new ArrayList<>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		// 정점의 수 작은것부터 하기 위한 정렬
		for (int i=1; i<N+1;i++) {
			g[i].sort((g1, g2) -> g1==g2? g2-g1 : g1-g2);
		}
		
		dfs(V);	
		v = new boolean[N+1];
		System.out.println();
		bfs(V);
		br.close();
	}
}
