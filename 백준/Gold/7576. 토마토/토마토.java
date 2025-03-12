import java.io.*;
import java.util.*;

class Main {
    static int M, N;
    static int[][] tomato ;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int unripeCount = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) q.offer(new int[] {i,j});
                else if (tomato[i][j] == 0) unripeCount ++;
            }
        }

        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int days = bfs(q);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);

        br.close();
    }

    public static int bfs(ArrayDeque<int[]> q) {

        int cnt = -1;

        while (!q.isEmpty()) {
                int size = q.size();
    
                for (int s=0; s<size; s++) {
                    int[] ij = q.poll();
                    int ii = ij[0]; int jj = ij[1];
    
                    for (int d=0; d<4; d++) {
                        int ni = ii + di[d];
                        int nj = jj + dj[d];
                
                        if (0<=ni && ni<N && 0<=nj && nj<M && tomato[ni][nj] == 0) {
                            q.offer(new int[] {ni,nj});
                            tomato[ni][nj] = 1;
                        }
                    }
                }
                cnt++; 
            }

        return cnt;
    }
}