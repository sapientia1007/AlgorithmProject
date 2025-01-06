import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static int[][] arr ; static StringTokenizer st;
	static boolean[][] v;
	static final int[] di = {0, 0, -1, 1, -1, 1, -1, 1}, 
			dj= {-1, 1, 0, 0, 1, 1, -1, -1};
	
	static void dfs (int i, int j) {
		v[i][j] = true;
		for (int d=0; d<8; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if (0<=ni && ni<w && 0<=nj && nj<h && !v[ni][nj] && arr[ni][nj]==1) {
				dfs(ni, nj);
			}

		}
	}
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[] {i,j});
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0]; j =ij[1];
			for (int d=0; d<8; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if (0<=ni && ni<w && 0<=nj && nj<h && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
			arr = new int[w][h]; v = new boolean[w][h];
			if (w==0 && h==0) {
				break;
			}
			for (int j=0; j<h;j++) {
				String[] inpStr = br.readLine().split(" ");
				for (int i=0 ; i<w; i++) {
					int num = Integer.parseInt(inpStr[i]);
					arr[i][j] = num;
					
					} 
				}
			for (int j=0; j<h;j++) {
				for (int i=0 ; i<w; i++) {		
					if (!v[i][j] && arr[i][j]==1) {
						dfs(i,j);
//						bfs(i,j);
						cnt +=1;
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
		
	}
}