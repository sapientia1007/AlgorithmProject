import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int[][] dist;
    static boolean[][] v;

    static int[] di = new int[] {-1,0,1,0};
    static int[] dj = new int[] {0,1,0,-1};

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];  v = new boolean[N][M]; 

        for(int i=0; i<N; i++) {
            String[] inpt = br.readLine().split("");
            for (int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(inpt[j]);
            }
        } 

        System.out.println(bfs(0,0));
    }

    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist = new int[N][M];
        q.offer(new int[] {i, j});
        v[i][j] = true;
        dist[i][j] = 1;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int ii = ij[0]; int jj = ij[1];

            if (ii == N-1 && jj == M-1) return dist[ii][jj];

            for (int d=0; d<4; d++) {
                int ni = ii + di[d];
                int nj = jj + dj[d];

                if (0<=ni && ni<N && 0<=nj && nj<M && arr[ni][nj] == 1 && !v[ni][nj]) {
                    dist[ni][nj] = dist[ii][jj]+1;
                    q.offer(new int[] {ni, nj});
                    v[ni][nj] = true;                   
                }
            }
        }
        return -1;
    }
}