import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr ;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        // 배추밭 가로 M, 배추밭 세로 N, 배추가 심어져 있는 개수 K
        for (int i=0; i<T; i++) {
            ArrayList<Integer> result = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            boolean[][] v = new boolean[N][M];
            for (int k=0; k<K; k++) {
                // 배추 [x,y]
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for (int n=0; n<N; n++) {
                for (int j=0; j<M; j++) {
                    if (!v[n][j] && arr[n][j] == 1) {
                        result.add(bfs(n,j,v,N,M));
                    }
                }
            }
            System.out.print(result.size()+ " ");
        }
        br.close();
    }

    public static int bfs(int n, int j, boolean[][] v, int N, int M){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {n,j});
        v[n][j] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int ii = current[0]; int jj = current[1];
            for (int d=0; d<4; d++) {
                int ni = ii + di[d];
                int nj = jj + dj[d];
                if (0<=ni && ni<N && 0<=nj && nj<M && arr[ni][nj] == 1 && !v[ni][nj]) {
                    q.offer(new int[] {ni, nj});
                    v[ni][nj] = true;
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
