import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static int[][] arr ; static StringTokenizer st;
	static boolean[][] v;
	static final int[] di = {0, 0, -1, 1, -1, 1, -1, 1}, dj= {-1, 1, 0, 0, 1, 1, -1, -1};

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

			for (int j=0; j<h; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i=0 ; i<w; i++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
				}
			}

			for (int r=0; r<h; r++) {
				for (int c=0; c<w; c++) {
					if (arr[c][r] == 1 && !v[c][r]){
						bfs(c,r);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
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
				if (0<=ni && ni<w && 0<=nj && nj<h && !v[ni][nj] &&arr[ni][nj]==1) {
					v[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}

}